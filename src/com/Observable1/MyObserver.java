package com.Observable1;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
    private String message;

    @Override
    public void update(Observable o, Object arg) {
        message = (String) arg;
        System.out.println("observer:"+o.getClass().getName()+"修改的状态"+message);
        /*synchronized (this){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("observer:"+o.getClass().getName()+"修改的状态"+message);
        }*/
    }


}
