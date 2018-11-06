package com.list;

//泛型类
public class Demo_Generic2 {
    public static void main(String[] args){
        Person<Integer> p1 =new Person<>();
        p1.setX(new Integer(123));
        System.out.println(p1.getX());

        Person<Double> p2 = new Person<>();
        p2.setX(new Double(12.50));
        System.out.println(p2.getX());

        Men<Integer,Float> m1 = new Men<>();
        m1.setC(new Float(4575.25f));
        System.out.println(m1.getC());

    }
}
//一个泛型变量
class Person<T>{
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}

//多个泛型变量，就是在<T,U,E>
class Men<T,U>{
    private T x;
    private T y;
    private U c;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public U getC() {
        return c;
    }

    public void setC(U c) {
        this.c = c;
    }
}
