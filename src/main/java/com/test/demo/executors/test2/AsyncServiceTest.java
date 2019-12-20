package com.test.demo.executors.test2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class AsyncServiceTest {

    @Async("asyncExecutor")
    public Future<Integer> methodB(){
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(1);
    }

    @Async("asyncExecutor")
    public Future<Integer> methodC(){
        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(2);
    }

    @Async("asyncExecutor")
    public Future<Integer> methodD(){
        try{
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(3);
    }

    @GetMapping("/test2")
    public Integer methodA() throws Exception{
        long start = System.currentTimeMillis();
        Future<Integer> future1 = this.methodB();
        Future<Integer> future2 = this.methodC();
        Future<Integer> future3 = this.methodD();
        Integer x = future1.get();
        Integer y = future2.get();
        Integer z = future3.get();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return x + y +z;
    }
}
