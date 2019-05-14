package com.Syn2;

public class Demo4 {
    public static void main(String[] args){

    }

    public synchronized void run(){
        int count = 0;

        for (int i = 0; i < 6; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Synchronized作用于整个方法的写法
     * 写法一修饰的是一个方法，写法二修饰的是一个代码块，但写法一与写法二是等价的，都是锁定了整个方法时的内容
     */
    //方法1
    public synchronized void run1(){

    }
    //方法2
    public void run2(){
        synchronized (this){

        }
    }

}

