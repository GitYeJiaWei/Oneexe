package com.Observable;

import java.util.Observable;
import java.util.Observer;

//具体的观察者
public class ConCreteObsever implements Observer {
    private String state;//具体观察者中的状态和目标对象的状态保持一致

    @Override
    public void update(Observable o, Object arg) {
        state = ((ConcreteSubject)o).getState();//获取到被观察者发送的数据
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
