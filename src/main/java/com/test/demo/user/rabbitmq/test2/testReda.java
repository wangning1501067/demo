package com.test.demo.user.rabbitmq.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testReda {

    public static void main(String[] args) throws IOException {
        /*try{
            System.out.println("请输入字符串：");
            //数组来缓冲
            byte[] b = new byte[5];
            //读取数据
            int n = System.in.read(b);
            //转换为字符串
            String s = new String(b,0,n);
            System.out.println("输入的字符串为：" + s);
        }catch(Exception e){}*/

        /*Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(s);*/

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
            String read = null;
            System.out.print("请输入数据：");
            try {
                read = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("输入的数据为："+read);

        }catch(Exception e){}
        }

}
