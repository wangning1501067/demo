package com.test.demo.websocket.demo2;

import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: guoyaocong@beyondsoft.com
 * @Date: 2020/4/22
 * @Description: websocket接口实现类
 */
@Component
public class ScoketClient implements WebSocketService {

    @Autowired
    private WebSocketClient webSocketClient;

    @Override
    public void groupSending(String message) {
        webSocketClient.send(message + "2020/4/22");
    }

    @Override
    public void appointSending(String name, String message) {
        // 这里指定发送的规则由服务端决定参数格式
        webSocketClient.send("TOUSER" + name + ";" + message);
    }
}
