package com.view;

/**
 * 在多线程环境下，将存在线程安全问题
 * yield(); join();
 */
public class Onemain {

    private static class MyThread extends Thread{
        MyThread(String a){
            super(a);
        }
        @Override
        public void run() {
            for (int i = 0; i <= 30; i++) {
                System.out.println(getName() + ":" + i);
                /*if (("t1").equals(getName())) {
                    //暂停当前正在执行的线程，并执行其他线程。（可能没有效果）
                    yield();
                }*/
            }
        }
    }

    public static void main(String[] args){
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");


        try {
            //t1.join()方法只会使主线程进入等待池并等待t1线程执行完毕后才会被唤醒。并不影响同一时刻处在运行状态的其他线程
            //当该线程终止的时候，会调用线程自身的notifyAll()方法,唤醒所有等待的线程
            //isAlive()判断是否是在运行状态，未启动和运行结束都不调用join方法
            t1.join(1);
            /*synchronized(t1){
                t1.wait();
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();

    }




}
