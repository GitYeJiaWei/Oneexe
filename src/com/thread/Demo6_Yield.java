package com.thread;

public class Demo6_Yield {
    /**
     * yield让出cpu礼让线程
     */
    public static void main(String[] args) {
        new MyThread1().start();
        new MyThread1().start();
    }

}

class MyThread1 extends Thread {
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            if(i % 10 == 0) {
                Thread.yield();						//让出CPU
            }
            System.out.println(getName() + "..." + i);
        }
    }
}
