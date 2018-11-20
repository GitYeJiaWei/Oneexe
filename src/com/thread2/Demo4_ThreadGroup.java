package com.thread2;

/**
 * ThreadGroup
 */

public class Demo4_ThreadGroup {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("我是一个新的线程组");
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(tg,mr,"zhangsan");
        Thread t2 = new Thread(tg,mr,"lisi");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        tg.setDaemon(true);
    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
    }
}
