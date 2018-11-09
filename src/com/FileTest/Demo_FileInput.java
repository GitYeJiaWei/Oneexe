package com.FileTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * read()方法读取的是一个字节,为什么返回是int,而不是byte
 * */
public class Demo_FileInput {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        FileInputStream fls = null;
        try {
            fls = new FileInputStream("E:\\upload\\必看.txt");  //创建流对象
            int b;
            while ((b =fls.read())!=-1){
                System.out.println(b);
            }
            fls.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
