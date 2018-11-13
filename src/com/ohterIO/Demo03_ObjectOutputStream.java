package com.ohterIO;

import com.view.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 序列化:将对象写到文件上
 * @throws IOException
 */
public class Demo03_ObjectOutputStream {
    public static void main(String[] args){
         //demo1();
         demo2();
    }

    public static void demo1(){
        Student st1 = new Student("af",12);
        Student st2 = new Student("fasdf",54);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mmm.txt"));
            oos.writeObject(st1);
            oos.writeObject(st2);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo2(){
        Student p1 = new Student("张三", 23);
        Student p2 = new Student("李四", 24);
        Student p3 = new Student("王五", 25);
        Student p4 = new Student("赵六", 26);

        ArrayList<Student> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("mmm.txt"));
            oos.writeObject(list);								//把整个集合对象一次写出
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}


