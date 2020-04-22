package com.test.demo.websocket.demo3.server;

/**
 * @ServerEndpoint 这个注解有什么作用？
 * <p>
 * 这个注解用于标识作用在类上，它的主要功能是把当前类标识成一个WebSocket的服务端
 * 注解的值用户客户端连接访问的URL地址
 * <p>
 * 服务端实现
 * 步骤一： springboot底层帮我们自动配置了websokcet，引入maven依赖
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-websocket</artifactId>
 * </dependency>
 * 步骤二：如果是你采用springboot内置容器启动项目的，则需要配置一个Bean。如果是采用外部的容器，则可以不需要配置。
 * （WebSocketConfig ）
 * 步骤三：最后一步当然是编写服务端核心代码了，其实小编不是特别想贴代码出来，贴很多代码影响文章可读性。
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint("/websocket/{name}")
public class MyWebSocketServer {

    /**
     *  与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 标识当前连接客户端的用户名
     */
    private String name;

    /**
     *  用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String, MyWebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    /**
 　　* 连接建立后触发的方法
 　　 */
    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name) {
        this.session = session;
        this.name = name;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketSet.put(name, this);
        log.info("[WebSocket] 连接成功，当前连接人数为：={}", webSocketSet.size());
    }

    /**
 　　* 连接关闭后触发的方法
 　　*/
    @OnClose
    public void OnClose() {
        webSocketSet.remove(this.name);
        log.info("[WebSocket] 退出成功，当前连接人数为：={}", webSocketSet.size());
    }

    /**
 　　 * 接收到客户端消息时触发的方法
 　　 */
    @OnMessage
    public void OnMessage(String message) {
        log.info("[WebSocket] 收到消息：{}", message);
        //判断是否需要指定发送，具体规则自定义
        if (message.indexOf("TOUSER") == 0) {
            String name = message.substring(message.indexOf("TOUSER") + 6, message.indexOf(";"));
            AppointSending(name, message.substring(message.indexOf(";") + 1, message.length()));
        } else {
            GroupSending(message);
        }

    }

    /**
 　　 * 发生错误时触发的方法
 　　*/
    @OnError
    public void onError(Session session, Throwable error) {
        log.info(session.getId() + "连接发生错误" + error.getMessage());
        error.printStackTrace();
    }

    /**
     * 群发
     * @param message
     */
    public void GroupSending(String message) {
        for (String name : webSocketSet.keySet()) {
            try {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 指定发送
     * @param name
     * @param message
     */
    public void AppointSending(String name, String message) {
        try {
            webSocketSet.get(name).session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}