package com.list;

//定义泛型数组
public class Demo_Generic5 {
    //定义
    public static <T> T[] fun1(T...arg){  // 接收可变参数
        return arg ;            // 返回泛型数组
    }
    //使用
    public static void main(String args[]){
        Integer i[] = fun1(1,2,3,4,5,6) ;
        Integer[] result = fun1(i) ;
    }
}
