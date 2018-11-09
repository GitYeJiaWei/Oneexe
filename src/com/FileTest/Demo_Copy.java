package com.FileTest;

import java.io.*;

public class Demo_Copy {
    public static void main(String[] args){
        //demo1();
        //deom2();
        //demo3();
        //demo4();
        //demo5();
        demo6();
    }

    public static void demo1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
             fis = new FileInputStream("E:\\upload\\必看.txt");		//创建输入流对象,关联txt
             fos = new FileOutputStream("E:\\upload\\必看1.txt",true);	//创建输出流对象,关联txt,true是叠加

            int b;
            while((b = fis.read()) != -1) {								//在不断的读取每一个字节
                fos.write(b);											//将每一个字节写出
            }

            fis.close();												//关流释放资源
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deom2(){
        try {
            FileInputStream fis = new FileInputStream("E:\\upload\\456.jpg");		//创建输入流对象,关联.jpg
            FileOutputStream fos = new FileOutputStream("E:\\upload\\789.jpg");	//创建输出流对象,关联.jpg

            int b;
            while((b = fis.read()) != -1) {								//在不断的读取每一个字节
                fos.write(b);											//将每一个字节写出
            }

            fis.close();												//关流释放资源
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo3(){
        try {
            FileInputStream fls = new FileInputStream("E:\\upload\\456.jpg");
            FileOutputStream flo = new FileOutputStream("E:\\upload\\987.jpg");

            byte[] arr = new byte[fls.available()];						//创建与文件一样大小的字节数组
            fls.read(arr);												//将文件上的字节读取到内存中
            flo.write(arr);												//将字节数组中的字节数据写到文件上

            fls.close();
            flo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo4(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\upload\\456.jpg");
            FileOutputStream fos = new FileOutputStream("E:\\upload\\copy.jpg");

            byte[] arr = new byte[1024 * 8];
            int len;                                            //fis.read(arr),将文件上的字节读取到字节数组中
            while((len = fis.read(arr)) != -1) {				//如果忘记加arr,返回的就不是读取的字节个数,而是字节的码表值
                fos.write(arr,0,len);
            }

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void demo5(){
        try {
            FileInputStream fis = new FileInputStream("E:\\upload\\456.jpg");       //创建输入流对象,关联致青春.mp3
            FileOutputStream fos = new FileOutputStream("E:\\upload\\123.jpg");			//创建输出流对象,关联copy.mp3
            BufferedInputStream bis = new BufferedInputStream(fis);				//创建缓冲区对象,对输入流进行包装让其变得更加强大
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int b;
            while((b = bis.read()) != -1) {
                bos.write(b);
            }

            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * * 字节流读取中文的问题
     * 字节流在读中文的时候有可能会读到半个中文,造成乱码
     * 字节流写出中文的问题
     * 字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组
     * 写出回车换行 write("\r\n".getBytes());
     */
    public static void demo6(){
        try {
            FileInputStream fis = new FileInputStream("必看.txt");
            byte[] arr = new byte[4];
            int len;
            while((len = fis.read(arr)) != -1) {
                System.out.println(new String(arr,0,len));
            }
            fis.close();

            FileOutputStream fos = new FileOutputStream("zzz.txt");
            fos.write("我读书少,你不要骗我".getBytes());
            fos.write("\r\n".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
