package com.mycollections;

import java.util.ArrayList;

public class Collection {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        java.util.Collection collection = new ArrayList();   //父类引用指向子类对象
        boolean b1 =collection.add("wuale");
        boolean b2 =collection.add(123);
        boolean b3 =collection.add(true);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(collection.size());
        System.out.println(collection.toString());
    }

    /*把集合转成数组，可以实现集合的遍历
     * toArray()*/
    public static void demo2() {
        java.util.Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");

        Object[] arr =c.toArray();					//将集合转换成数组
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
