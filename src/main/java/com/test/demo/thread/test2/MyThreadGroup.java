package com.test.demo.thread.test2;

/**
 * ThreadGroup用法
 * @author coshaho
 *
 */
public class MyThreadGroup implements Runnable {
    @Override
    public void run() {
        try {
            //测试线程是否已经中断。
            while (!Thread.currentThread().isInterrupted()) {
                //获得当前线程的引用。获得当前线程后对其进行操作。
                Thread currentThread = Thread.currentThread();
                System.out.println("current thread:" + currentThread.getName()
                        +"; thread group:"+currentThread.getThreadGroup().getName()
                        +"; parent thread group:"+currentThread.getThreadGroup().getParent().getName());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadGroup rootThreadGroup = new ThreadGroup("root线程组1");
        Thread t0 = new Thread(rootThreadGroup, new MyThreadGroup(), "Thread 0");
        //t0.start();
        //ThreadGroup tg = new ThreadGroup(rootThreadGroup,"线程组1");
        Thread t1 = new Thread(rootThreadGroup, new MyThreadGroup(), "Thread 1");
        t1.start();

        /*ThreadGroup tg2 = new ThreadGroup(rootThreadGroup,"线程组2");

        Thread t2 = new Thread(tg, new MyThreadGroup(), "Thread 2");
        t1.start();
        t2.start();
        Thread t3 = new Thread(tg2, new MyThreadGroup(), "Thread 3");
        Thread t4 = new Thread(tg2, new MyThreadGroup(), "Thread 4");
        t3.start();
        t4.start();*/
    }
}
