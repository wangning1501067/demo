package com.test.demo.thread.test2;

/**
 * ThreadLocal用法
 * @author coshaho
 *
 */
public class MyThreadLocal {
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static void main(String[] args) {
        new Thread(new MyStringTask("StringTask1")).start();
        //new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyStringTask implements Runnable {
        private String name;

        MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                /*if (null == MyThreadLocal.threadLocal.get()) {
                    MyThreadLocal.threadLocal.set("a");
                    System.out.println("线程" + name + ": a");
                } else {*/
                    String str = (String) MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(str + "a");
                    System.out.println("线程" + name + ": " + MyThreadLocal.threadLocal.get());
                //}
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
