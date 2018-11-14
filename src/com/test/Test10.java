package com.test;

import java.io.File;

public class Test10 {
    public static void main(String[] args){
        File file =Test9.getDir();
        printLev(file,0);
    }

    public static void printLev(File dir,int lev) {
        //1,把文件夹中的所有文件以及文件夹的名字按层级打印
        File[] subFiles = dir.listFiles();
        //2,遍历数组
        for (File subFile : subFiles) {
            for(int i = 0; i <= lev; i++) {
                System.out.print("\t");
            }
            //3,无论是文件还是文件夹,都需要直接打印
            System.out.println(subFile);
            //4,如果是文件夹,递归调用
            if(subFile.isDirectory()) {
                //printLev(subFile,lev + 1);
                printLev(subFile,++lev);
            }
        }
    }
}
