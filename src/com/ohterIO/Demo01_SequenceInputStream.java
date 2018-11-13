package com.ohterIO;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 整合两个输入流
 * SequenceInputStream(InputStream s1, InputStream s2)
 * 整合多个输入流
 * SequenceInputStream(Enumeration<? extends InputStream> e)
 */
public class Demo01_SequenceInputStream {
    public static void main(String[] args){
        //demo1();
        demo2();

    }

    public static void demo1(){
        try {
            FileInputStream fis = new FileInputStream("ttt.txt");      //创建字节输入流关联ttt.txt
            FileInputStream fis1 = new FileInputStream("times.txt");   //创建字节输入流关联times.txt
            SequenceInputStream sis = new SequenceInputStream(fis,fis1);
            FileOutputStream fos = new FileOutputStream("ww.txt");

            int d;
            while ((d = sis.read())!=-1){
                fos.write(d);
            }
            fos.close();
            sis.close();                                        //sis在关闭的时候,会将构造方法中传入的流对象也都关闭

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo2(){
        try {
            FileInputStream fis = new FileInputStream("ttt.txt");      //创建字节输入流关联ttt.txt
            FileInputStream fis1 = new FileInputStream("times.txt");   //创建字节输入流关联times.txt
            FileInputStream fis2 = new FileInputStream("zzz.txt");

            Vector<FileInputStream> vector = new Vector<>();            //创建集合对象
            vector.add(fis);                                            //将流对象存储进来
            vector.add(fis1);
            vector.add(fis2);

            Enumeration enumeration = vector.elements();
            SequenceInputStream sis = new SequenceInputStream(enumeration);     //将枚举中的输入流整合成一个
            FileOutputStream fos = new FileOutputStream("kkk.txt");

            int d;
            while ((d = sis.read())!=-1){
                fos.write(d);
            }
            fos.close();
            sis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
