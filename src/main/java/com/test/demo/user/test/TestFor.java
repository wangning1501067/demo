package com.test.demo.user.test;

public class TestFor {
    public static void main(String argv[]) {
        int i;
        int j;
        /**
         * 如果想跳出它所代表的循环，那么就break outer;
         * 如果想结束它所代表的此次循环，那么就continue outer;
         */
        outer:for (i = 0; i < 3; i++) {
            inner:for (int k = 0; k <3 ; k++) {
                if (i==1) {
                    break outer;
                }else{
                    System.out.println("i="+i+"=k="+k);
                }
            }
        }
    }
}
