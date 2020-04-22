package com.test.demo.websocket.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * soringboot启动类，注意放在包外层，防止启动无法访问
 */
@SpringBootApplication
public class Demo3Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }
}
