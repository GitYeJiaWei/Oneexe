package com.FileTest;

import java.io.*;
import java.util.Scanner;

public class Demo_FileTest1 {
    public static void main(String[] args){
        File file =getFile();
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("ttt.txt"));

            int b;
            while ((b=bis.read())!=-1){
                bos.write(b);
            }
            bos.write("大厦不".getBytes());
            bos.write("\r\n".getBytes());

            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 定义一个方法获取键盘录入的文件路径,并封装成File对象返回
     * 1,返回值类型File
     * 2,参数列表无
     */
    public static File getFile() {
        Scanner sc = new Scanner(System.in);				//创建键盘录入对象
        System.out.println("请输入一个文件的路径:");
        while(true) {
            String line = sc.nextLine();					//接收键盘录入的路径
            File file = new File(line);						//封装成File对象,并对其进行判断
            if(!file.exists()) {
                System.out.println("您录入的文件路径不存在,请重新录入:");
            }else if(file.isDirectory()) {
                System.out.println("您录入的是文件夹路径,请重新录入:");
            }else {
                return file;
            }
        }
    }


}
