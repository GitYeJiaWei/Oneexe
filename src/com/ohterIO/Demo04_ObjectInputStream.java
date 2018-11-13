package com.ohterIO;

import com.view.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Demo04_ObjectInputStream {
    public static void main(String[] args){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("kkk.txt"));
            ArrayList<Student> list = (ArrayList<Student>) ois.readObject();		//将集合对象一次读取

            for (Student s : list) {
                System.out.println(s);
            }

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
