package com.test.demo.socket.demo3.server;

/**
 *
 * @ServerEndpoint 这个注解有什么作用？
 *
 * 这个注解用于标识作用在类上，它的主要功能是把当前类标识成一个WebSocket的服务端
 * 注解的值用户客户端连接访问的URL地址
 *
 * 服务端实现
 * 步骤一： springboot底层帮我们自动配置了websokcet，引入maven依赖
 * 步骤二：如果是你采用springboot内置容器启动项目的，则需要配置一个Bean。如果是采用外部的容器，则可以不需要配置。
 * 步骤三：最后一步当然是编写服务端核心代码了，其实小编不是特别想贴代码出来，贴很多代码影响文章可读性。
 */


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Socket服务端，用来接收客户端请求，实现转大写功能
 *
 * */

public class WebSocketServer {
    public static void main(String[] args) throws Exception{
        //1、建立服务器端的tcp socket服务， 必须监听一个端口
        ServerSocket ss = new ServerSocket(9999);
        while(true){
            System.out.println("等待客户端请求.....");

            //2、通过服务器端的socket对象的accept方法获取连接上的客户端de对象，没有则堵塞
            Socket socket = ss.accept();

            //3、通过输入流获取数据
            InputStream input = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = input.read(b);
            String data = new String(b, 0, len);
            System.out.println("客户端数据为：" + data);

            //4、通过服务器socket输出流，写数据，会传到客户端socket输入流中
            OutputStream output = socket.getOutputStream();
            output.write(data.toUpperCase().getBytes());

            //5、关闭socket
            output.close();
            input.close();
            socket.close();
        }

    }
}