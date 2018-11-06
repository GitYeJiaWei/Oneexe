package com.view;
/*final修饰特点
 * 修饰类，类不能被继承
 * 修饰变量，变量就变成了常量，只能被赋值一次
 * 修饰方法，方法不能被重写*/
public class Final {
    public static void main(String[] args){
       Son son = new Son();
       son.print();
       son.sisi();

       Father father = new Son();        //父类引用指向子类对象,调用的是子类重写的方法
       father.print();
       father.sisi();

       Father father1 = new Father();
       father1.print();
       father1.sisi();
    }
}

class Father{
    final int NUM = 10;						//常量命名规范,如果是一个单词,所有字母大写,如果是多个单词,每个单词都大写,中间用下划线隔开
    public static final double PI = 3.14;	//final修饰变量叫做常量,一般会与public static共用
    public void print() {
        System.out.println(NUM);
    }

    public void sisi(){
        System.out.println("12345");
    }
}

class Son extends Father{
    int NUM =12;
    //重写父类的方法
    public void print(){
        System.out.println(NUM);
    }
}
