package com.thread;

public class Demo1_Name {
    public static void main(String[] args){
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println(this.getName()+"123");
            }
        };
        t1.setName("zhangsan");
        t1.start();
    }

}
