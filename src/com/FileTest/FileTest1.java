package com.FileTest;

import java.io.File;
import java.io.IOException;

/**
*  java.io.IOException: 系统找不到指定的路径
*  创建文件的时候，要保证对应的文件夹已经存在
*
 * * A:编译期异常和运行期异常的区别
 * Java中的异常被分为两大类：编译时异常和运行时异常。
 * 所有的RuntimeException类及其子类的实例被称为运行时异常，其他的异常就是编译时异常

 * 编译时异常
 * Java程序必须显示处理，否则程序就会发生错误，无法通过编译
 * 运行时异常
 * 无需显示处理，也可以和编译时异常一样处理
 * B:案例演示
 * 编译期异常和运行期异常的区别
 编译时异常也叫做未雨绸缪异常(老师自己定义的)
 未雨绸缪:在做某些事情的时候要做某些准备
 编译时异常:在编译某个程序的时候,有可能会有这样那样的事情发生,比如文件找不到,这样的异常就必须在编译的时候处理
 如果不处理编译通不过

 运行时异常:就是程序员所犯得错误,需要回来修改代码
 */
public class FileTest1 {
    public static void main(String[] args){
        //demo1();
        //demo2();
        //demo3();
        demo4();
    }

    public static void demo1(){
        //创建文件的时候，要保证对应的文件夹已经存在
        File file =new File("E:\\hello\\world\\Java\\a.text");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("创建文件失败！");
            e.printStackTrace();
        }
    }

    public static void demo2(){
        //创建文件的时候，要保证对应的文件夹已经存在
        File file = new File("E:\\upload\\world\\java");
        file.mkdirs();

        File file1 =new File(file,"a.text");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            System.out.println("创建文件失败！");
            e.printStackTrace();
        }
    }

    public static void demo3(){
        int a = 10;
        int b = 0;
        int[] arr = {11,22,33,44,55};

        try {
            System.out.println(a / b);
            System.out.println(arr[10]);
            arr = null;
            System.out.println(arr[0]);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为零");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("索引越界了");
        } catch (Exception e) {				//Exception e = new NullPointerException();
            System.out.println("出错了");
        }

        try {
            System.out.println(1/0);
        } catch (Exception e) {			//Exception e = new ArithmeticException("/ by zero");
            //System.out.println(e.getMessage());		//获取异常信息
            //System.out.println(e); 		//调用toString方法,打印异常类名和异常信息
            e.printStackTrace();		//jvm默认就用这种方式处理异常
        }
        System.out.println("over");

    }

    /**
     * * A:finally的特点
     * 被finally控制的语句体一定会执行
     * 特殊情况：在执行到finally之前jvm退出了(比如System.exit(0))
     * B:finally的作用
     * 用于释放资源，在IO流操作和数据库操作中会见到
     * C:案例演示
     * finally关键字的特点及作用
     *return语句相当于是方法的最后一口气,那么在他将死之前会看一看有没有finally帮其完成遗愿,如果有就将finally执行
     *后在彻底返回
     */
    public static void demo4(){
        try {
            System.out.println(10/0);
        } catch (Exception e) {
            System.out.println("除数为零了");
            System.exit(0);								//退出jvm虚拟机
            return;
        } finally {
            System.out.println("看看我执行了吗");
        }
    }
}
