//package com.test.demo.websocket.demo3.controller;
//
//
//import com.test.demo.websocket.demo3.service.impl.ScoketClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther: liaoshiyao
// * @Date: 2019/1/11 16:47
// * @Description: 测试后台websocket客户端
// */
//@RestController
//@RequestMapping("/websocket")
//public class IndexController {
//
//    @Autowired
//    private ScoketClient webScoketClient;
//
//    @GetMapping("/sendMessage")
//    public String sendMessage(String message){
//        webScoketClient.groupSending(message);
//        return message;
//    }
//}
