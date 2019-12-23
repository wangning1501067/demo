package com.test.demo.event.test1;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * 定义事件监听器
 * @author Administrator
 *
 */
@Component
public class Mylistener implements ApplicationListener<MyEvent>{
    //<写要监听的对象>

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("我开始监听"+event.getClass());

    }
}
