package com.Observable;

import java.util.Observable;

//具体的对象，被观察者
public class ConcreteSubject extends Observable {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void updataState(String s){
        state = s ;//目标对象发生了改变

        setChanged();//Observable类中的setChanged（）方法，表示目标对象发生了更改
        notifyObservers(state);//通知所有观察者对象
    }
}
