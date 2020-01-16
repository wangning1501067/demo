//package com.test.demo.event.test4;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
///**
// * 编写一个类MyEventHandler，替代上文中的MyApplicationListener，将其纳入spring容器中，编写一个带参的方法，参数为需要监听的事件的父类或需要监听的事件，加上@EventListener。（参数的范围越广泛，监听到的事件越多）
// */
//@Component
//public class MyEventHandler {
//
//    @EventListener
//    public void event(MyEvent event) {
//        /**
//         * 括号中的参数不能为空，可以任意
//         * 若为Object event，则所有事件都可以监听到
//         */
//        System.out.println("MyEventHandler又要监听"+event.getClass());
//
//        /*System.out.println("---------------------------");
//        System.out.println("MyEventHandler==利用@EventListener注解监听用户注册事件并向用户发送邮件");
//        System.out.println("MyEventHandler==注册用户名：" + event.getUserTest().getUsername());*/
//        System.out.println("MyEventHandler=="+event.getUserTest().toString());
//    }
//}
