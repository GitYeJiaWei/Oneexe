package com.view;
/**
 * 装饰设计模式的好处是:
 * 耦合性不强,被装饰的类的变化与装饰类的变化无关
 */
public class wrap {
    public static void main(String[] args){
        teacher t = new teacher(new student());
        t.print();
    }
}

interface code{
    void print();
}

class student implements code{

    @Override
    public void print() {
        System.out.println("this is student");
    }
}

class teacher implements code{
    //1,获取被装饰类的引用
    private student s;						//获取学生引用

    //2,在构造方法中传入被装饰类的对象
    public teacher(student s) {
        this.s = s;
    }

    //3,对原有的功能进行升级
    @Override
    public void print() {
        System.out.println("this is teacher");
    }
}
