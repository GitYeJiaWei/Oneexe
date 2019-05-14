package com.Syn2;

/**
 * 其效果和【Demo5】是一样的，synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁
 */
public class Demo6 {
    public static void main(String[] args){
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1,"thread1");
        Thread thread2 = new Thread(syncThread2,"thread2");
        thread1.start();
        thread2.start();
    }
}

/**
 * 同步线程
 */
class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public static void method() {
        synchronized(SyncThread.class) {
            for (int i = 0; i < 4; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void run() {
        method();
    }
}