package com.mycollections;

//泛型函数定义及使用
public class Demo_Generic3 {
    public static void main(String[] args){
        //静态方法
        StaticFans.demo1("qwasdf");
        StaticFans.<String>demo1("asdfwe"); //建议这种方式

        //常规方法
        StaticFans demo_generic2 = new StaticFans();
        demo_generic2.demo2(456);
        demo_generic2.<Integer>demo2(123);  //建议这种方式
    }

}

class StaticFans {
    //静态函数
    public static <T> void demo1(T t){
        System.out.println(t);
    }

    //常规函数
    public <T> void demo2(T t){
        System.out.println(t);
    }

}
