package com.FileTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo_FileReader {
    public static void main(String[] args){

        //demo1();
        demo2();
    }

    public static void demo1(){
        try {
            FileReader fr = new FileReader("hhh.txt");
            int c;
            while ((c=fr.read())!=-1){          //通过项目默认的码表一次读取一个字符
                System.out.println((char) c);
            }
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo2(){
        try {
            FileWriter fw = new FileWriter("kkk.txt");
            fw.write("啊手动阀开始就");
            fw.write(97);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
