package com.test.demo.rocketmq.controller;

import com.test.demo.rocketmq.config.JmsConfig;
import com.test.demo.rocketmq.producer.PayProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/iam/rocket")
public class PayController {

    @Autowired
    private PayProducer payProducer;



    @GetMapping("/test")
    public Object callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        // 创建消息  主题   二级分类   消息内容好的字节数组
        Message message = new Message(JmsConfig.TOPIC, "taga", ("hello rocketMQ " + text).getBytes());

        SendResult send = payProducer.getProducer().send(message);

        System.out.println(send);

        return new HashMap<>();
    }

}

