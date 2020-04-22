package com.test.demo.websocket.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送类
 */
@RestController
@RequestMapping(value = "/websocket")
public class WebSendController {

    @Autowired
    private ScoketClient webScoketClient;

    @GetMapping("/sendMessage")
    public String sendMessage(String message) {
        webScoketClient.groupSending(message);
        return message;
    }

}
