package com.test.demo.user.rabbitmq.test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by alber on 2017/1/9.
 * 生产者
 */
public class MyProducer2 {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv)throws java.io.IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //      设置RabbitMQ地址
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("192.168.23.121");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        //      创建一个新的连接
        Connection connection = factory.newConnection();
        //      创建一个频道
        Channel channel = connection.createChannel();
        //      声明一个队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //for (int i = 0; i < 5; i++) {
        //获取控制台输入文字
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String message=sc.next();
            if(message.equals("quit")) //当用户输入quit 单词时退出Scanner
            {
                System.out.println("退出");
                break;
            }
            //System.out.println(message);

            //String message = "Hello World!" + (i);
            //      发送消息到队列中
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //      关闭频道和连接
        channel.close();
        connection.close();
    }
}
