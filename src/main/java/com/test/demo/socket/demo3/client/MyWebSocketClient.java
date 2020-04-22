package com.test.demo.socket.demo3.client;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 客户端用来发给服务端请求
 *
 * */

public class MyWebSocketClient {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        //1、创建一个基于TCP协议的socket服务，在建立对象时，要指定连接服务器和端口号
        Socket sc = new Socket("127.0.0.1", 9999);
        //2、通过建立的socket对象获取socket中的输出流，调用getOutStream方法
        OutputStream out = sc.getOutputStream();

        System.out.println("输入要转化的字母 ：");
        String initData = input.next();//获取控制台的输入

        //3、写入到socket输出流中
        out.write(initData.getBytes());
        System.out.println("等待服务器端返回数据");

        //4、通过建立socket对象获取socket中的输入流，输入流会接受来自服务器端数据
        InputStream in = sc.getInputStream();
        byte[] b = new byte[1024];

        //5、获取输入字节流的数据，注意此方法是堵塞的，如果没有获取数据会一直等待
        int len = in.read(b);
        System.out.println("返回结果为： " + new String(b, 0, len));

        //关闭socket
        out.close();
        in.close();
        sc.close();
        input.close();

    }

}