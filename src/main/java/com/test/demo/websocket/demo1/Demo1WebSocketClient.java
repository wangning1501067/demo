package com.test.demo.websocket.demo1;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class Demo1WebSocketClient extends WebSocketClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo1WebSocketClient.class);

    public Demo1WebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        // TODO Auto-generated method stub
        LOGGER.info("------ MyWebSocket onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        // TODO Auto-generated method stub
        LOGGER.info("------ MyWebSocket onClose ------{}",arg1);
    }

    @Override
    public void onError(Exception arg0) {
        // TODO Auto-generated method stub
        LOGGER.info("------ MyWebSocket onError ------{}",arg0);
    }

    @Override
    public void onMessage(String arg0) {
        // TODO Auto-generated method stub
        LOGGER.info("-------- 接收到服务端数据： " + arg0 + "--------");
    }
}
