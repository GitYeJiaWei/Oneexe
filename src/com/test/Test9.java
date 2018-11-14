package com.test;

import java.io.*;
import java.util.Scanner;

/**
 * 需求:1,从键盘接收一个文件夹路径,统计该文件夹大小
 *
 * 从键盘接收一个文件夹路径
 * 1,创建键盘录入对象
 * 2,定义一个无限循环
 * 3,将键盘录入的结果存储并封装成File对象
 * 4,对File对象判断
 * 5,将文件夹路径对象返回
 *
 * 统计该文件夹大小
 * 1,定义一个求和变量
 * 2,获取该文件夹下所有的文件和文件夹listFiles();
 * 3,遍历数组
 * 4,判断是文件就计算大小并累加
 * 5,判断是文件夹,递归调用
 */
public class Test9 {
    public static void main(String[] args){
        File file =getDir();
        System.out.println(getFileLength(file));
        //deleteFile(file);          //删除文件夹
        File copy = getDir();
        if (copy.equals(file)){
            System.out.println("两个文件夹同属同意路径");
        }else{
            try {
                copy(file,copy);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 从键盘接收一个文件夹路径
     * 1,返回值类型File
     * 2,参数列表无
     */
    public static File getDir() {
        //1,创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径:");
        //2,定义一个无限循环
        while(true) {
            //3,将键盘录入的结果存储并封装成File对象
            String line = sc.nextLine();
            File dir = new File(line);
            //4,对File对象判断
            if(!dir.exists()) {
                System.out.println("您录入的文件夹路径不存在,请输入一个文件夹路径:");
            }else if(dir.isFile()) {
                System.out.println("您录入的是文件路径,请输入一个文件夹路径:");
            }else {
                //5,将文件夹路径对象返回
                return dir;
            }
        }

    }

    /*
     * 统计该文件夹大小
     * 1,返回值类型long
     * 2,参数列表File dir
     */
    public static long getFileLength(File dir) {	//dir = F:\day06\day07
        //1,定义一个求和变量
        long len = 0;
        //2,获取该文件夹下所有的文件和文件夹listFiles();
        File[] subFiles = dir.listFiles();			//day07 Demo1_Student.class Demo1_Student.java
        //3,遍历数组
        for (File subFile : subFiles) {
            //4,判断是文件就计算大小并累加
            if(subFile.isFile()) {
                len = len + subFile.length();
                //5,判断是文件夹,递归调用
            }else {
                len = len + getFileLength(subFile);
            }
        }
        return len;
    }

    /*
     * 删除该文件夹
     * 1,返回值类型 void
     * 2,参数列表File dir
     */
    public static void deleteFile(File dir) {
        //1,获取该文件夹下的所有的文件和文件夹
        File[] subFiles = dir.listFiles();
        //2,遍历数组
        for (File subFile : subFiles) {
            //3,判断是文件直接删除
            if(subFile.isFile()) {
                subFile.delete();
                //4,如果是文件夹,递归调用
            }else {
                deleteFile(subFile);
            }
        }
        //5,循环结束后,把空文件夹删掉
        dir.delete();
    }

    /**
     * mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹， 如下：
     *
     * new File("/tmp/one/two/three").mkdirs();
     *
     * 执行后， 会建立tmp/one/two/three四级目录
     *
     * new File("/tmp/one/two/three").mkdir();
     *
     * 则不会建立任何目录， 因为找不到/tmp/one/two目录， 结果返回false
     */
    public static void copy(File src, File dest) throws IOException {
        //1,在目标文件夹中创建原文件夹
        File newDir = new File(dest, src.getName());
        newDir.mkdir();
        //2,获取原文件夹中所有的文件和文件夹,存储在File数组中
        File[] subFiles = src.listFiles();
        //3,遍历数组
        for (File subFile : subFiles) {
            //4,如果是文件就用io流读写
            if(subFile.isFile()) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subFile));
                BufferedOutputStream bos =
                        new BufferedOutputStream(new FileOutputStream(new File(newDir,subFile.getName())));

                int b;
                while((b = bis.read()) != -1) {
                    bos.write(b);
                }

                bis.close();
                bos.close();
                //5,如果是文件夹就递归调用
            }else {
                copy(subFile,newDir);
            }
        }
    }
}
