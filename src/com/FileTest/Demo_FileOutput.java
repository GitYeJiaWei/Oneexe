package com.FileTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @throws IOException
 * FileOutputStream在创建对象的时候是如果没有这个文件会帮我创建出来
 * 如果有这个文件就会先将文件清空
 */
public class Demo_FileOutput {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        try {
            //如果想续写就在第二个参数传true
            //创建字节输出流对象,如果没有就自动创建一个
            //虽然写出的是一个int数,但是到文件上的是一个字节,会自动去除前三个8位
            FileOutputStream flo =new FileOutputStream("E:\\upload\\abc.txt",true);
            flo.write(97);
            flo.write(98);
            flo.write(97);
            flo.write(98);
            flo.write(97);
            flo.write(98);
            flo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
