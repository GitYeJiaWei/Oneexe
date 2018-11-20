package com.thread2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁：ReentrantLock
 */
public class Demo3_ReentrantLock {
    public static void main(String[] args) {
        final Printer3 p3 = new Printer3();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        p3.print1();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    while (true) {
                        try {
                            p3.print2();
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                {
                    while (true) {
                        try {
                            p3.print3();
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
}

class Printer3 {
    private ReentrantLock r = new ReentrantLock();
    private Condition c1 = r.newCondition();
    private Condition c2 = r.newCondition();
    private Condition c3 = r.newCondition();

    private int flag = 1;

    public void print1() throws InterruptedException {
        r.lock();                               //获取锁
        if (flag!=1){
            c1.await();                         // 造成当前线程在接到信号或被中断之前一直处于等待状态。
        }
        System.out.print("黑");
        System.out.print("马");
        System.out.print("程");
        System.out.print("序");
        System.out.print("员");
        System.out.println(Thread.currentThread().getName());
        System.out.println("\r\n");
        flag =2;
        //this.notify();						//随机唤醒单个等待的线程
        c2.signal();                           //唤醒一个等待线程
        r.unlock();								//释放锁
    }

    public void print2() throws InterruptedException {
        r.lock();
        if (flag!=2){
            c2.await();
        }
        System.out.print("传");
        System.out.print("智");
        System.out.print("播");
        System.out.print("客");
        System.out.println(Thread.currentThread().getName());
        System.out.print("\r\n");
        flag =3;
        c3.signal();
        r.unlock();
    }

    public void print3() throws InterruptedException {
        r.lock();
        if(flag != 3) {
            c3.await();
        }
        System.out.print("i");
        System.out.print("t");
        System.out.print("h");
        System.out.print("e");
        System.out.print("i");
        System.out.print("m");
        System.out.print("a");
        System.out.println(Thread.currentThread().getName());
        System.out.print("\r\n");
        flag = 1;
        c1.signal();
        r.unlock();
    }
}
