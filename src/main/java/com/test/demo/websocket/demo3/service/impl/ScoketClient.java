//package com.test.demo.websocket.demo3.service.impl;
//
//
//import com.test.demo.websocket.demo3.client.MyWebSocketClient;
//import com.test.demo.websocket.demo3.service.WebSocketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @Auther: liaoshiyao
// * @Date: 2019/1/12 10:56
// * @Description: websocket接口实现类
// */
//@Component
//public class ScoketClient implements WebSocketService {
//
//    @Autowired
//    private MyWebSocketClient webSocketClient;
//
//    @Override
//    public void groupSending(String message) {
//        // 这里我加了6666-- 是因为我在index.html页面中，要拆分用户编号和消息的标识，只是一个例子而已
//        // 在index.html会随机生成用户编号，这里相当于模拟页面发送消息
//        // 实际这样写就行了 webSocketClient.send(message)
//        webSocketClient.send(message+"---6666");
//    }
//
//    @Override
//    public void appointSending(String name, String message) {
//        // 这里指定发送的规则由服务端决定参数格式
//        webSocketClient.send("TOUSER"+name+";"+message);
//    }
//}
