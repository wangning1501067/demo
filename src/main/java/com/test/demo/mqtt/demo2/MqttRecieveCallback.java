package com.test.demo.mqtt.demo2;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * 接收消息客户端回调函数：
 */
public class MqttRecieveCallback implements MqttCallback{

    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Client 接收消息主题 : " + topic);
        System.out.println("Client 接收消息Qos : " + message.getQos());
        System.out.println("Client 接收消息内容 : " + new String(message.getPayload()));


    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

}
