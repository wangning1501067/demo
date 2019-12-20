package com.test.demo.user.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by alber on 2017/1/9.
 * 生产者
 */
public class MyProducer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String QUEUE_NAME = "hello2";
        ConnectionFactory factory = new ConnectionFactory();
//      设置RabbitMQ地址
        factory.setHost("192.168.23.121");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
//      创建一个新的连接
        Connection connection = factory.newConnection();
//      创建一个频道
        Channel channel = connection.createChannel();
//      声明一个队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //发送五条
        for (int i = 0; i < 5; i++) {
            String message = "Hello World!=="+ i+1;
//      发送消息到队列中
            // 开启confirm 模式 单个模式
            //channel.confirmSelect();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("P [x] Sent '" + message + "'");
            /*if (!channel.waitForConfirms()) {
                System.out.println("发送消息失败  此处要处理发送消息失败后的逻辑.");
            }*/
            Thread.sleep(1000);
        }
//      关闭频道和连接
        channel.close();
        connection.close();
    }
}

