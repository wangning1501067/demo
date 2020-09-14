package com.test.demo.mqtt.demo1.client;

import com.test.demo.mqtt.demo1.common.*;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;
/**
 * Created by StoneGeek on 2018/6/5.
 * mqtt客户端
 */
@Slf4j
public class ClientMQTT {
    public static final String HOST = "tcp://192.168.23.121:1882";
    public static final String TOPIC = "mtopic";
    private static final String clientid = "client11";
    private MqttClient client;
    private MqttConnectOptions options;
    private String userName = "test";
    private String passWord = "test2020";

    private ScheduledExecutorService scheduler;

    private void start() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 设置回调
            client.setCallback(new PushCallback());
            MqttTopic topic = client.getTopic(TOPIC);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            //options.setWill(topic, "close".getBytes(), 2, true);

            client.connect(options);
            //订阅消息
            int[] Qos  = {1};
            String[] topic1 = {TOPIC};
            client.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //	发布消息
    public void publishMessage(String pubTopic,String message,int qos) {
        //cleanTopic(TOPIC);
        if(null != client&& client.isConnected()) {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(message.getBytes());
            MqttTopic topic = client.getTopic(pubTopic);
            if(null != topic) {
                try {

                    MqttDeliveryToken publish = topic.publish(mqttMessage);
                    if(!publish.isComplete()) {
                        //publish.waitForCompletion();
                        log.info("消息发布成功");
                        cleanTopic(pubTopic);
                    }
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }else {
            reConnect();
        }
    }

    //	重新连接
    public  void reConnect() {
        if(null != client) {
            if(!client.isConnected()) {
                if(null != options) {
                    try {
                        client.connect(options);
                    } catch (MqttException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else {
                    log.error("mqttConnectOptions is null");
                }
            }else {
                log.error("client is null or connect");
            }
        }else {
            //init("client11");
        }

    }

    //	清空主题
    public void cleanTopic(String topic) {
        if(null != client&& !client.isConnected()) {
            try {
                client.unsubscribe(topic);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("mqttClient is error");
        }
    }


    public static void main(String[] args) throws MqttException {
        ClientMQTT client = new ClientMQTT();
        client.start();

        client.publishMessage("mtopic", "111111", 1);
    }
}
