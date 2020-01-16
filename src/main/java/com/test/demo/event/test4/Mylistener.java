package com.test.demo.event.test4;

import org.springframework.context.ApplicationListener;

/**
 *
 * 定义事件监听器
 * @author Administrator
 *
 */
//第一种加载监听器到spring容器里面
//@Component
public class Mylistener implements ApplicationListener<MyEvent>{
    //<写要监听的对象>



    //第一种加载监听器到spring容器里面
    @Override

    //第二种加载监听器到spring容器里面
    //@EventListener
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Mylistener==我开始监听"+event.getClass());

        //监听UserTest
        // 把事件中的信息获取到
        UserTest user = event.getUserTest();
        /*if(user == null){
            System.out.println("=====================");
            return ;
        }
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等
        System.out.println("Mylistener==用户名：" + user.getUsername());
        System.out.println("Mylistener==密码：" + user.getPass());*/

        System.out.println("Mylistener=="+event.getUserTest().toString());
    }
}
