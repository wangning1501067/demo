package com.test.demo.rockermq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 生产者
 */
public class Producer {
    public static void main(String[] args) throws MQClientException {

        //创建生产者并指定组
        DefaultMQProducer producer = new DefaultMQProducer("my-group");
        //指定服务地址，指定NameServer地址，多个地址以 ; 隔开
        //producer.setNamesrvAddr("192.168.118.3:9876;192.168.118.4:9876;192.168.23.121:9876");
        producer.setNamesrvAddr("192.168.23.121:9876");
        //创建生产者实例
        producer.setInstanceName("producer");
        //Rocket默认开启了VIP通道，VIP通道端口为10911-2=10909。若Rocket服务器未启动端口10909，则报connect to <：10909> failed。
        producer.setVipChannelEnabled(false);
        //启动生成者
        producer.start();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000); // 每秒发送一次MQ

                Message msg = new Message("my-topic11", // topic 主题名称
                        "TagA22"+i, // tag 临时值
                        ("message-"+i).getBytes()// body 内容
                );

                SendResult sendResult = producer.send(msg);
                //打印消息的完整信息
                System.out.println(sendResult.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //发送完所有信息停掉生产者
        producer.shutdown();
    }
}