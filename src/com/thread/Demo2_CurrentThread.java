package com.thread;

public class Demo2_CurrentThread {
    public static void main(String[] args){
        new Thread() {
            public void run() {
                System.out.println(getName() + "....aaaaaa");
            }
        }.start();


        new Thread(new Runnable() {
            public void run() {
                //Thread.currentThread()获取当前正在执行的线程,这里的是子线程
                System.out.println(Thread.currentThread().getName() + "...bb");
            }
        }).start();

        //这里输出的是主线程
        Thread.currentThread().setName("我是主线程");
        System.out.println(Thread.currentThread().getName());
    }
}
