package com.test.demo.synchronized1;

public class SynchronizedTest {

    private static Object object = new Object();

    public static void main(String[] args) {
        synchronized (object){
            System.out.println("只有我拿到锁啦1");
        }

        lockMethod();
    }

    /**
     * 这样加锁是加在了this当前类对象上的。如果不加static，锁是加在类对象上的，需要注意我们用的spring的bean作用域
     */
    public static synchronized void lockMethod() {
        System.out.println("只有我拿到锁啦2");
    }
}
