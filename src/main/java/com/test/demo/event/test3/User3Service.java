package com.test.demo.event.test3;

import com.test.demo.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class User3Service {

    /**
     * 获取用户信息
     * @return
     */
    public User getUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new User("倪升武", "123456");
    }
}
