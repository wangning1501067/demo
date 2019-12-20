package com.test.demo.user.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by alber on 2017/1/9.
 * 消费者
 */
public class MyConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
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
//      声明要关注的队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("C [*] Waiting for messages. To exit press CTRL+C");
//      DefaultConsumer类实现了Consumer接口，通过传入一个频道，告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery

        //声明一个消费者,配置好获取消息的方式
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) ;
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer) ;

        while (true){
            //循环获取消息
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //try {
                        //Thread.sleep(1000);
                        String message = new String(body, "UTF-8");
                        System.out.println("C [x] Received '" + message + "'");
                        // 这里接受到消息手动ack
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    /*} catch (Exception e) {
                        e.printStackTrace();
                    }*/
                }
            };
//      自动回复队列应答

            boolean autoAck = false;
            channel.basicConsume(QUEUE_NAME, autoAck, consumer);
        }

        //System.in.read();
    }
}
