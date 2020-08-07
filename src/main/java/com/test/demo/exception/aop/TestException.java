package com.test.demo.exception.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestException {

    public String testException(){
        String flag = "ok";

        Integer num = null;
        try{
            num.intValue();
        }catch (Exception e){
            flag = "no";
            log.error("=================================");
            //System.out.println("======================");
            //throw new NullPointerException(")000000000");
        }

        return flag;
    }

    public static void main(String[] args) {
        TestException test = new TestException();
        test.testException();
    }

    @RequestMapping("/test-get")
    public String testGet(){
        return this.testException();
    }
}
