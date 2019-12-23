package com.test.demo.event.test2.event;

import com.test.demo.user.model.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author shengwu ni
 * @date 2018/07/05
 */
@Data
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    // 省去 get、set 方法
}
