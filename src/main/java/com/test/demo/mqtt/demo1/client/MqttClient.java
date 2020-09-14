package com.test.demo.mqtt.demo1.client;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import com.test.demo.mqtt.demo1.common.*;

@Slf4j
public class MqttClient {

    public static org.eclipse.paho.client.mqttv3.MqttClient mqttClient = null;
    private static MemoryPersistence memoryPersistence = null;
    private static MqttConnectOptions mqttConnectOptions = null;

    private static MqttClient instance = null;

    public static MqttClient getInstance() throws Exception {
        if (instance == null) {
            synchronized (MqttClient.class) {
                if (instance == null) {
                    instance = new MqttClient();
                }
            }
        }
        return instance;
    }

    public MqttClient(){
        init("client12");
    }

    public void init(String clientId) {
        //初始化连接设置对象
        mqttConnectOptions = new MqttConnectOptions();
        //初始化MqttClient
        if(null != mqttConnectOptions) {
//			true可以安全地使用内存持久性作为客户端断开连接时清除的所有状态
            mqttConnectOptions.setCleanSession(true);
//			设置连接超时
            mqttConnectOptions.setConnectionTimeout(30);

            // 设置连接的用户名
            mqttConnectOptions.setUserName("test");
            // 设置连接的密码
            mqttConnectOptions.setPassword("test2020".toCharArray());

//			设置持久化方式
            memoryPersistence = new MemoryPersistence();
            if(null != memoryPersistence && null != clientId) {
                try {
                    mqttClient = new org.eclipse.paho.client.mqttv3.MqttClient("tcp://192.168.23.121:1882", clientId,memoryPersistence);
                    mqttClient.setCallback(new PushCallback());
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {

            }
        }else {
            log.error("mqttConnectOptions对象为空");
        }
        //设置连接和回调
        if(null != mqttClient) {
            if(!mqttClient.isConnected()) {
                try {
                    log.info("创建连接:" + mqttClient.isConnected());

                    MqttTopic topic = mqttClient.getTopic("mtopic");
                    //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
                    //mqttConnectOptions.setWill(topic, "close".getBytes(), 2, true);

                    mqttClient.connect(mqttConnectOptions);

                    //订阅消息
                    int[] Qos  = {1};
                    String[] topic1 = {"mtopic"};
                    mqttClient.subscribe(topic1, Qos);
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }else {
            log.error("mqttClient为空");
        }
    }

    //	关闭连接
    public void closeConnect() {
        //关闭存储方式
        if(null != memoryPersistence) {
            try {
                memoryPersistence.close();
            } catch (MqttPersistenceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("memoryPersistence is null");
        }

//		关闭连接
        if(null != mqttClient) {
            if(mqttClient.isConnected()) {
                try {
                    mqttClient.disconnect();
                    mqttClient.close();
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {
                log.error("mqttClient is not connect");
            }
        }else {
            log.error("mqttClient is null");
        }
    }

    //	发布消息
    public void publishMessage(String pubTopic,String message,int qos) {
        if(null != mqttClient&& mqttClient.isConnected()) {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(message.getBytes());
            MqttTopic topic = mqttClient.getTopic(pubTopic);
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
        if(null != mqttClient) {
            if(!mqttClient.isConnected()) {
                if(null != mqttConnectOptions) {
                    try {
                        mqttClient.connect(mqttConnectOptions);
                    } catch (MqttException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else {
                    log.error("mqttConnectOptions is null");
                }
            }else {
                log.error("mqttClient is null or connect");
            }
        }else {
            init("client11");
        }

    }
    //	订阅主题
    public void subTopic(String topic) {
        if(null != mqttClient&& mqttClient.isConnected()) {
            try {
                mqttClient.subscribe(topic, 1);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("mqttClient is error");
        }
    }


    //	清空主题
    public void cleanTopic(String topic) {
        if(null != mqttClient&& !mqttClient.isConnected()) {
            try {
                mqttClient.unsubscribe(topic);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            log.error("mqttClient is error");
        }
    }

    public static  void main(String [] args){
        MqttClient mqttClient = new MqttClient();
        mqttClient.publishMessage("mtopic", "222222", 1);
    }

}
