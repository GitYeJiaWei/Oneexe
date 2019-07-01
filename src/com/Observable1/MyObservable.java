package com.Observable1;

import java.util.Observable;

/**
 * 被观察者添加线程，每过一秒改变一次数据，并提醒所有观察者
 */
public class MyObservable extends Observable implements Runnable {
    private String message;

    public void upadte(String s){
        message = s;
        setChanged();
        notifyObservers(message);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            upadte("threadtime:"+System.currentTimeMillis());
        }
    }
}
