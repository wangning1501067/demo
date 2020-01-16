package com.test.demo.event.test4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableConfigurationProperties
@SpringBootApplication
//这个注解囊括了多个注解的大注解
public class SpringbootApplication {

    /**
     * 1、自定义事件，一般是继承ApplicationEvent抽象类 (MyEvent)
     *   2、定义事件监听器，一般是实现ApplicationListener接口 (Mylistener)
     *   3、 1）把监听器加入到SpringApplication中：ApplicationListener.addListener();然后发布事件 ()
     *       2）或放置到spring容器:@Conponent
     *       3）或在application.properties配置文件中配置context.listener.classes=监听器全类名
     *       4）或在META-INF/spring.factories配置文件中配置org.springframework.context.ApplicationListener=监听器全类名
     *       5）或编写一个类，纳入spring容器中，编写一个带参的方法，参数为事件的父类或需要监听的事件，加上@EventListener
     *   3、发布事件
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        //ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

        //Mylistener==第二种加载监听器到spring容器里面
        //context.addApplicationListener(new Mylistener());//第三条：3.启动的时候，需要把监听器加入到spring容器中
        //context.publishEvent(new MyEvent(new Object(), new UserTest()));//发布消息
        //context.close();
    }
}
