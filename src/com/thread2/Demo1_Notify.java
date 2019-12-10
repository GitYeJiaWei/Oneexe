package com.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 等待唤醒机制
 */
public class Demo1_Notify {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        final Printer p = new Printer();

        executors.execute(new Runnable() {
            @Override
            public void run() {

                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        executors.execute(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

class Printer{
    private int flag = 2;
    public void print1() throws InterruptedException {
        synchronized(this) {
            this.wait();
            if (flag != 1) {        //while循环是循环判断,每次唤醒都会判断标记，if只进行一次判断，下次唤醒直接执行之后的程序
                					//当前线程等待
            }
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.println(Thread.currentThread().getName());
            System.out.print("\r\n");
            flag = 1;
            this.notify();						//随机唤醒单个等待的线程
            //this.notifyAll();                  //唤醒所有等待线程
        }
    }

    public void print2() throws InterruptedException {
        synchronized(this) {
            if (flag != 2) {
                this.wait();
            }
            System.out.print("传");
            System.out.print("智");
            System.out.print("播");
            System.out.print("客");
            System.out.println(Thread.currentThread().getName());
            System.out.print("\r\n");
            flag = 1;
            this.notify();
        }
    }
}


