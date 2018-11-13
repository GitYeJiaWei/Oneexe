package com.ohterIO;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ByteArrayOutputStream
 * 内存输出流
 *
 * FileInputStream读取中文的时候出现了乱码
 *
 * 解决方案
 * 1,字符流读取
 * 2,ByteArrayOutputStream
 * @throws IOException
 */
public class Demo02_ByteArrayOutputStream {
    public static  void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("ttt.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();			//在内存中创建了可以增长的内存数组

            int b;
            while((b = fis.read()) != -1) {
                baos.write(b);													//将读取到的数据逐个写到内存中
            }

            //byte[] arr = baos.toByteArray();									//将缓冲区的数据全部获取出来,并赋值给arr数组
            //System.out.println(new String(arr));

            System.out.println(baos.toString());								//将缓冲区的内容转换为了字符串,在输出语句中可以省略调用toString方法
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
