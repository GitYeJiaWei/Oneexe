package com.thread;

public class Demo1_Thread {
    public static void main(String[] args){
        for(int i = 0; i < 100000; i++) {
            new demo();
        }

        for(int i = 0; i < 10000; i++) {
            System.out.println("我是主线程的执行代码");
        }
    }
}

class demo{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾被清扫了");
    }
}
