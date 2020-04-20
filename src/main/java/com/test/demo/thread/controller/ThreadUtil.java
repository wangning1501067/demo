package com.test.demo.thread.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

@Configuration
@Slf4j
public class ThreadUtil {

    private Integer num2 = 1000000;
    @Async
    public Future<Boolean> compare(Integer num){
        log.debug("======num:{}", num);
        if (num == num2) {
            return new AsyncResult<>(true);
        }
        return new AsyncResult<>(false);
    }

    @Async
    public void compare1(Integer num){
        log.debug("======num:{}", num);
        if (num == num2) {
            //log.debug("===结果===true");
        }
        //log.debug("===结果===false");
    }
}
