package com.FileTest;

import java.io.File;
import java.io.IOException;

/**
 * * A:创建功能
 * public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
 * public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
 * public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
 * B:案例演示
 * File类的创建功能

 * 注意事项：
 * 如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。
 *
 *  A:重命名和删除功能
 * 			* public boolean renameTo(File dest):把文件重命名为指定的文件路径
 * 			* public boolean delete():删除文件或者文件夹
 * 		* B:重命名注意事项
 * 			* 如果路径名相同，就是改名。
 * 			* 如果路径名不同，就是改名并剪切。
 * 		* C:删除注意事项：
 * 			* Java中的删除不走回收站。
 * 			* 要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
 *
 * 	A:判断功能
 * 		* public boolean isDirectory():判断是否是目录
 * 		* public boolean isFile():判断是否是文件
 * 		* public boolean exists():判断是否存在
 * 		* public boolean canRead():判断是否可读
 * 		* public boolean canWrite():判断是否可写
 * 		* public boolean isHidden():判断是否隐藏
 *
 * 	*A:获取功能
 * 		* public String getAbsolutePath()：获取绝对路径
 * 		* public String getPath():获取路径
 * 		* public String getName():获取名称
 * 		* public long length():获取长度。字节数
 * 		* public long lastModified():获取最后一次的修改时间，毫秒值
 * 		* public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 * 		* public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
 */
public class FileTest2 {
    public static void main(String[] args){
        //demo1();
        demo2();
    }

    public static void demo1(){
        File file = new File("E:\\upload\\world\\java");
        File file1 =new File(file,"e.txt");
        System.out.println(file1.exists());
        System.out.println(file.exists());
    }

    public static void demo2(){
        File file = new File("E:\\upload\\world\\java");
        File file1 =new File(file,"k.txt");
        file1.mkdirs();                                        //创建多级目录

        //如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下
        File file2 =new File("ye.txt");
        file2.mkdir();                                          //创建默认目录下的文件

        File file3 =new File(file,"ye.txt");
        try {
            file1.createNewFile();                              //如果没有就创建,返回true
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file1.exists());
        System.out.println(file.exists());


    }
}
