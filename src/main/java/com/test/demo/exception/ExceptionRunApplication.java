package com.test.demo.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * soringboot启动类，注意放在包外层，防止启动无法访问
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.test.demo.exception"})
public class ExceptionRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionRunApplication.class, args);
    }

}
