package com.test.demo.user.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class MainController{
    @Autowired
    private RedisLock redisLock;

    @GetMapping("/test")
    public void test() {
        log.debug("==================");
        String key = "wang:ning:test";
        String token = null;
        try{

            token = redisLock.lock(key, 10000, 11000);
            if(token != null) {
                System.out.print("我拿到了锁哦");
                // 执行业务代码
            } else {
                System.out.print("我没有拿到锁唉");
            }
        } finally {
            if(token!=null) {
                String key2 = "wang:ning:test:"+getNum();
                redisLock.unlock(key2, token);
            }
        }
    }

    public int getNum() {
        System.out.println("Method one:" + Math.random() * 100);
        Random random = new Random();
        System.out.println("Method two:" + random.nextInt(100));
        return random.nextInt(100);
    }
}