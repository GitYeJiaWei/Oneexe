package com.list;


public class Demo_Array {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        Srudent[] arr = new Srudent[5];				//创建引用数据类型数组
        arr[0] = new Srudent(23,"张三");				//创建一个学生对象,存储在数组的第一个位置
        arr[1] = new Srudent(24,"李四");				//创建一个学生对象,存储在数组的第二个位置
        arr[2] = new Srudent(12,"王五");				//创建一个学生对象,存储在数组的第三个位置

        for(int i = 0; i < arr.length; i++) {
            if (arr[i]!=null){
                System.out.println(arr[i].getName());
            }
        }
    }
}
