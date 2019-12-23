package com.test.demo.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableConfigurationProperties
@SpringBootApplication
//这个注解囊括了多个注解的大注解
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);


        /*ConfigurableApplicationContext context=SpringApplication.run(SpringbootApplication.class, args);

        //context.addApplicationListener(new Mylistener());//第三条：3.启动的时候，需要把监听器加入到spring容器中
        //如果这里不把监听器加入到spring容器中，那么需要在监听器类中加上@component,标注,具体见如下MyEventHandler.java
        context.publishEvent(new MyEvent(new Object()));  //发布消息
        context.close();*/
    }
}
