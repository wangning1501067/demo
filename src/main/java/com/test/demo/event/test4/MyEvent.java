package com.test.demo.event.test4;

import org.springframework.context.ApplicationEvent;

/**
 *
 * 定义事件
 * 还需要定义一个监听器
 *
 * ApplicationEvent，它是所有内置事件和自定义事件的父接口,如ApplicationStartedEvent
 *
 */
public class MyEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;

    private UserTest userTest;

    public UserTest getUserTest() {
        return userTest;
    }

    public void setUserTest(UserTest userTest) {
        this.userTest = userTest;
    }

    public MyEvent(Object source, UserTest userTest) {
        //定义成Object类
        super(source);

        //监听UserTest
        this.userTest = userTest;
    }
}
