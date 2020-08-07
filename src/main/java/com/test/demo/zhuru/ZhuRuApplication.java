package com.test.demo.zhuru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * soringboot启动类，注意放在包外层，防止启动无法访问
 */
@SpringBootApplication
public class ZhuRuApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhuRuApplication.class, args);
    }

}
