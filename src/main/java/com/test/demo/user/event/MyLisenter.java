package com.test.demo.user.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 测试用自定义监听器,监听事件为MyEvent
 * @component就是说把这个类交给Spring管理
 */
@Component
public class MyLisenter implements ApplicationListener<MyEvent> {

    /**
     * 对监听到的事件进行处理
     *
     * @param myEvent
     */
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        /*
          这里不做处理，只对消息进行透传打印，实际情况，
          可以根据项目进行逻辑进行处理
         */
        myEvent.printMsg(myEvent.getMsg());
    }
}
