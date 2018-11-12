package com.FileTest;

import java.io.File;

public class FileTest3 {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        File file =new File("E:\\");

        String[] arr =file.list();    //获取E盘下的所有文件名
        for (String s:arr){
            if (s.endsWith(".jpg")){
                System.out.print(s+"  ");
            }
        }

        File[] files = file.listFiles();   //获取e盘下所有的文件或文件夹对象
        for (File file1:files){
            if (file1.isFile() && file1.getName().endsWith(".jpg")){
                System.out.println(file1.getName()+" ");
            }

        }
    }
}
