package com.test.demo.thread.controller;

import com.beyondsoft.box.common.response.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/sys/test")
@Slf4j
public class TestController {

    private Integer num = 1000000;

    @Autowired
    private ThreadUtil threadUtil;

    @GetMapping("/get")
    public ObjectRestResponse getOneuser() throws ExecutionException, InterruptedException {
        ObjectRestResponse<Object> restResponse = new ObjectRestResponse<>();
        long time1=System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            Future<Boolean> fl = this.threadUtil.compare(i);
            if (fl.get()) {
                restResponse.setData(200);
                break;
            }else{
                restResponse.setData(-1);
            }
        }
        long time2=System.currentTimeMillis();
        System.out.println("get当前程序耗时："+(time2-time1)+"ms");
        return restResponse;
    }

    @GetMapping("/get2")
    public ObjectRestResponse getOneuser2() throws ExecutionException, InterruptedException {
        ObjectRestResponse<Object> restResponse = new ObjectRestResponse<>();
        long time1=System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            log.debug("======num:{}", i);
            if (i == num) {
                restResponse.setData(200);
                break;
            }else{
                restResponse.setData(-1);
            }
        }
        long time2=System.currentTimeMillis();
        System.out.println("get2当前程序耗时："+(time2-time1)+"ms");
        return restResponse;
    }

    @GetMapping("/get1")
    public ObjectRestResponse getOneuser1() throws ExecutionException, InterruptedException {
        ObjectRestResponse<Object> restResponse = new ObjectRestResponse<>();
        long time1=System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            this.threadUtil.compare1(i);
        }
        long time2=System.currentTimeMillis();
        System.out.println("get1当前程序耗时："+(time2-time1)+"ms");
        return restResponse;
    }

    public static void main(String[] args) {
        //线程
        /*Callable callable = new Callable() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        };
        *//**
         * 将callable丢进任务里面
         *//*
        FutureTask futureTask = new FutureTask(callable);

        *//**
         * 启动线程, 执行任务
         *//*
        new Thread(futureTask).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("执行任务后的结果: " + futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*Map<String,String> map=new HashMap();
        map.put("id","01");
        map.put("name","guojing");
        map.put("salary","8000");
        map.put("age","18");

        Map<String,String> map1=new LinkedHashMap<>();
        map1.put("id","02");
        map1.put("name","huangrong");
        map1.put("salary","7000");
        map1.put("age","17");

        String json= JSON.toJSONString(map);
        String json1=JSON.toJSONString(map1);

        System.out.println(json);
        System.out.println(json1);*/

    }



}
