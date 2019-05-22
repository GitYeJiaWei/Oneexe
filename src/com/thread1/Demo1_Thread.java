package com.thread1;

/**
 * Java多线程实现方式主要有四种：1继承Thread类、2实现Runnable接口、
 * 3实现Callable接口通过FutureTask包装器来创建Thread线程、4使用ExecutorService、Callable、Future实现有返回结果的多线程
 */

/**
 * 1、继承Thread类创建线程
 * Thread类本质上是实现了Runnable接口的一个实例，
 * 代表一个线程的实例。启动线程的唯一方法就是通过Thread类的start()实例方法。s
 * tart()方法是一个native方法，它将启动一个新线程，并执行run()方法。这种方式实现多线程很简单，
 * 通过自己的类直接extend Thread，并复写run()方法，就可以启动新线程并执行自己定义的run()方法
 */
public class Demo1_Thread {
    public static void main(String[] args){
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread.run()");
    }
}


