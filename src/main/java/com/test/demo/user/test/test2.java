package com.test.demo.user.test;

/**
 * @Description : test2
 * @Author : wangningning
 * @Date: 2020/6/8 9:35
 */
public class test2 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(true && ((num++)==1));
        System.out.println(num);

        String str = "hello world";
        System.out.println(str.charAt(1));

        char symbol = '8';
        System.out.println((int) symbol);

        int i = 0;
        /*while(i++<3)
            System.out.print("A");
            System.out.print("B");*/


        while(i++<3)
            System.out.print("A");System.out.print("B");

        System.out.println();
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a==b);
        System.out.println(c==d);

        int i2 = 100;
        i2 =+ 2; //注意，加号在后面
        System.out.println(i2);
        int i3 = 100;
        i3 += 2; //注意，加号在后面
        System.out.println(i3);

        //\\u000d System.out.println("Hello World!");

//        show01
    }
}
