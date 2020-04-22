package com.test.demo.websocket.demo2;

/**
 * @Author: guoyaocong@beyondsoft.com
 * @Date: 2020/4/22
 * @Description: websocket接口
 */
public interface WebSocketService {

    /**
     * 群发
     *
     * @param message
     */
    void groupSending(String message);

    /**
     * 指定发送
     *
     * @param name
     * @param message
     */
    void appointSending(String name, String message);
}
