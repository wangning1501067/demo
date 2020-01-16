package com.test.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 通过注解方式注入过滤器
 */
@WebListener
public class IndexListener2 implements ServletContextListener{
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("IndexListener2 contextDestroyed method");
    }
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("IndexListener2 contextInitialized method");
    }
}

