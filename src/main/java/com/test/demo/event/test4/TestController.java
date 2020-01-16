package com.test.demo.event.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/test-update")
    public String testUpdate(){
        UserTest userTest = new UserTest();
        userTest.setUsername("2222222");
        //System.out.println("UserTest="+userTest.toString());

        // 发布事件
        MyEvent event = new MyEvent(this, userTest);
        applicationContext.publishEvent(event);
        return "===OK===";
    }
}
