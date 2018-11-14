package com.ohterIO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo08_RandomAccessFile {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hhh.txt", "rw");
        //raf.write(97);
        //int x = raf.read();
        //System.out.println(x);
        raf.seek(0);					//在指定位置设置指针
        raf.write(97);                  //在0位置写入a，97在码表上的值对应为a
        raf.close();
    }
}
