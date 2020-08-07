package com.test.demo.zhuru.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BuyerProductController {
    private static ApplicationContext applicationContext;
    @Autowired
    private ZhuRuTest zhuRuTest;
    //@Autowired
    //private ZhuRuTest2 zhuRuTest2;
    @GetMapping(value = "/get")
    public String get(){
        return "1111111111";
    }


}
