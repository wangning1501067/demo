package com.test.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * soringboot启动类，注意放在包外层，防止启动无法访问
 */
//springboot 2.0.5.RELEASE以上版本，可以通过@ComponentScan注解来指定注解类，以便扫描，启动类可以随便放
@ComponentScan(basePackages = {"com.test.demo.user.mapper", "com.test.demo"})
@SpringBootApplication
//使用注解的方式声明Listener时，需要再main函数类上添加@ServletComponentScan（basePackages = "此处写明类地址，格式为包名+类名"）
@ServletComponentScan(basePackages = "com.test.demo.user.listener.*")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
