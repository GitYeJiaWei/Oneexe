package com.view;

/**
 * 在Java中有两种形式可以实现多态。继承和接口
 *
 * 分析：在这个程序中子类Sons重载了父类Fathers的方法fun1()，重写fun2()，
 *      而且重载后的fun1(String a)与 fun1()不是同一个方法，由于父类中没有该方法，
 *      向上转型后会丢失该方法，所以执行Sons的Fathers类型引用是不能引用fun1(String a)方法。
 *      而子类Sons重写了fun2() ，那么指向Sons的Fathers引用会调用Sons中fun2()方法
 *
 *  所以对于多态我们可以总结如下：
 *
 *       指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性，
 *       而对于子类中存在而父类中不存在的方法，该引用是不能使用的，尽管是重载该方法。
 *       若子类重写了父类中的某些方法，在调用该些方法的时候，
 *       必定是使用子类中定义的这些方法（动态连接、动态调用）。
 */
public class FatherSon {
    public static void main(String[] args){
        Fathers a = new Sons();
        a.fun1();
    }

}

class Fathers{
    public void fun1(){
        System.out.println("father"+"fun1");
        fun2();
    }

    public void fun2(){
        System.out.println("father"+"fun2");
    }
}

class Sons extends Fathers{
    /**
     * @desc 子类重载父类方法
     *        父类中不存在该方法，向上转型后，父类是不能引用该方法的
     * @return void
     */
    public void fun1(String st1){
        System.out.println("son"+"fun1");
    }

    /**
     * 子类重写父类方法,实现多态
     * 指向子类的父类引用调用fun2时，必定是调用该方法
     */
    public void fun2(){
        System.out.println("son"+"fun2");
    }
}
