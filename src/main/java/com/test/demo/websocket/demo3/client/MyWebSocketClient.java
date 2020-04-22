package com.test.demo.websocket.demo3.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.jboss.logging.Logger;

import java.net.URI;

public class MyWebSocketClient extends WebSocketClient {

    Logger logger = Logger.getLogger(MyWebSocketClient.class);

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
// TODO Auto-generated method stub
        logger.info("------ MyWebSocket onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        // TODO Auto-generated method stub
        logger.info("------ MyWebSocket onClose ------");
    }

    @Override
    public void onError(Exception arg0) {
        // TODO Auto-generated method stub
        logger.info("------ MyWebSocket onError ------");
    }

    @Override
    public void onMessage(String arg0) {
        // TODO Auto-generated method stub
        logger.info("-------- 接收到服务端数据： " + arg0 + "--------");
    }
}