package com.Observable1;

public class MainObserver1 {
    public static void main(String[] args){
        MyObservable myObservable = new MyObservable();

        MyObserver o1 = new MyObserver();
        MyObserver o2 = new MyObserver();
        MyObserver o3 = new MyObserver();

        myObservable.addObserver(o1);
        myObservable.addObserver(o2);
        myObservable.addObserver(o3);
        /*System.out.println("-------------未修改的状态-------------");
        System.out.println(o1.getMessage());
        System.out.println(o2.getMessage());
        System.out.println(o3.getMessage());*/

        Thread thread1 = new Thread(myObservable);
        thread1.start();
    }
}
