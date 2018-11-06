package com.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo_Iterator {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        Collection c = new ArrayList();
        c.add(new Srudent(12,"wudi"));
        c.add(new Srudent(23,"xiaqi"));
        c.add(new Srudent(14,"shabi"));

        //获取迭代器（遍历）
        Iterator iterator =c.iterator();

        //判断集合中是否有元素,有就返回true
        while (iterator.hasNext()){
            Srudent srudent = (Srudent) iterator.next();
            System.out.println(srudent.getName()+" "+srudent.getAge());
        }
    }

}
