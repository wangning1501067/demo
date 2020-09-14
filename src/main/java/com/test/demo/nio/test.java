package com.test.demo.nio;

import java.nio.ByteBuffer;

public class test{
    public static void main(String[] args) {
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->"+byteBuffer.limit());
        System.out.println("初始时-->position--->"+byteBuffer.position());
        System.out.println("初始时-->capacity--->"+byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());
        System.out.println("--------------------------------------");
        // 添加一些数据到缓冲区中
        String s = "Java3y"; byteBuffer.put(s.getBytes());
        // 看一下初始时4个核心变量的值
        System.out.println("put完之后-->limit--->"+byteBuffer.limit());
        System.out.println("put完之后-->position--->"+byteBuffer.position());
        System.out.println("put完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());
    }
}
