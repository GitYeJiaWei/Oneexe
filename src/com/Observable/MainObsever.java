package com.Observable;

public class MainObsever {
    public static void main(String[] args){
        //构建目标对象（被观察者）
        ConcreteSubject subject = new ConcreteSubject();
        //定义多个具体的观察者
        ConCreteObsever c1 = new ConCreteObsever();
        ConCreteObsever c2 = new ConCreteObsever();
        ConCreteObsever c3 = new ConCreteObsever();
        c1.setState("12");//设置观察者的初始状态
        c2.setState("23");
        c3.setState("32");

        //将三个观察者加入到观察者队列中
        subject.addObserver(c1);//Observable 接口中使用addObserver来添加观察者到集合中
        subject.addObserver(c2);
        subject.addObserver(c3);

        //将第一个观察者对象剔除
        subject.deleteObserver(c1);

        //输出未修改的状态
        System.out.println("-------------未修改的状态-------------");
        System.out.println(c1.getState());
        System.out.println(c2.getState());
        System.out.println(c3.getState());

        System.out.println("-------------修改后的状态-------------");
        //改变目标对象的状态
        subject.updataState("33");//使用刚才定义的updatastate()方法来跟新状态

        System.out.println(c1.getState());
        System.out.println(c2.getState());
        System.out.println(c3.getState());
    }
}
