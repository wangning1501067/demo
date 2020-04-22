package com.test.demo.websocket.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * soringboot启动类，注意放在包外层，防止启动无法访问
 */
@SpringBootApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }


    @Bean
    public static Demo1WebSocketClient webSocketClient() {
        Demo1WebSocketClient webSocketClient = null;
        try {
            webSocketClient = new Demo1WebSocketClient(new URI("ws://121.40.165.18:8800"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        webSocketClient.connect();
        return webSocketClient;
    }
}
