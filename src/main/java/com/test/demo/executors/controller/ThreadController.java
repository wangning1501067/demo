package com.test.demo.executors.controller;

import com.test.demo.executors.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qjwyss
 * @date 2018/10/12
 * @description
 */
@RestController
public class ThreadController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/sss")
    public String sss() {

        //调用service层的任务
        for (int i = 0; i < 50; i++) {
            asyncService.executeAsync(i);

            //getTest();
        }

        return "OK";
    }

    private void getTest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
