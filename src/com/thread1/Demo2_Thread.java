package com.thread1;


import com.NewJdk.Demo_Class;

/**
 * 2、实现Runnable接口创建线程
 * 如果自己的类已经extends另一个类，就无法直接extends Thread，此时，可以实现一个Runnable接口
 * 为了启动MyThread，需要首先实例化一个Thread，并传入自己的MyThread实例
 */
public class Demo2_Thread {
    public static void main(String[] args){
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.start();
    }
}

class MyThread1 extends Demo_Class implements Runnable{

    public void run(){
        System.out.println("MyThread1");
    }
}
