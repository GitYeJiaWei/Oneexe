package com.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A:泛型概述
 * B:泛型好处
 * 提高安全性(将运行期的错误转换到编译期)
 * 省去强转的麻烦
 * C:泛型基本使用
 * <>中放的必须是引用数据类型
 * D:泛型使用注意事项
 * 前后的泛型必须一致,或者后面的泛型可以省略不写(1.7的新特性菱形泛型)

 */
public class Generic {
    public static void main(String[] args){
        demo1();
        demo2();
    }

    public static void demo1(){
        ArrayList<Srudent> arrayList =new ArrayList<>();
        arrayList.add(new Srudent(45,"wuli"));
        arrayList.add(new Srudent(42,"wilihh"));

        Iterator<Srudent> it =arrayList.iterator();
        while (it.hasNext()){
            //next方法只能调用一次,如果调用多次会将指针向后移动多次
            Srudent srudent =it.next();
            System.out.println(srudent.getName()+" "+srudent.getAge());
        }
    }

    public static void demo2() {
        ArrayList<String> list = new ArrayList<>();			//创建集合对象
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
