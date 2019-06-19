package com.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo7_Wait {
    private static boolean isRun = true;
    private static Object lock = new Object();
    private static boolean isLock = false;

    public static void main(String[] args){
        ExecutorService executors = Executors.newFixedThreadPool(2);
        OneRunable oneRunable = new OneRunable();
        TwoRunable twoRunable = new TwoRunable();
        executors.submit(oneRunable);
        executors.submit(twoRunable);

        //executors.shutdown();//关闭多线程
    }

    static class OneRunable implements  Runnable{

        @Override
        public void run() {
            while (isRun){
                synchronized (lock){
                    if (isLock){
                        try {
                            //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        try {
                            //当前线程等待1秒，不释放对象锁，1秒到了之后继续执行该线程
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName());
                        isLock = true;
                        //调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                        lock.notifyAll();
                    }

                }
            }
        }
    }

    static class TwoRunable implements Runnable{

        @Override
        public void run() {
            while (isRun){
                synchronized (lock){
                    if (isLock){
                        System.out.println(Thread.currentThread().getName());
                        isLock = false;
                        lock.notifyAll();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}




