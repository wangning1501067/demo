package com.test.demo.thread.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author qjwyss
 * @date 2018/10/12
 * @description
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

//直接使用@Async注解，并声明线程池，即可使用多线程；
    @Async("taskExecutor")
    @Override
    public void executeAsync(int i) {
        logger.info("start executeAsync"+"========="+i);
        try {
            System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("end executeAsync"+"========="+i);
    }

}