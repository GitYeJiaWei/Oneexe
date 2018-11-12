package com.FileTest;

import java.io.*;

/**
 * 使用FileInputStream和FileReader进行文件的读写，方式都是使用read(buf[])的方式，
 * 然后通过while循环进行输出。需要注意的是，FileInputStream读的是字节数组byte[]，
 * 而FileReader读的是字符数组char[]。这也就是在构造String对象式出现不同的方式的原因。
 * 对于byte[]数组，如果不存在中文，那么直接使用
 * public String(byte[] bytes,
 *               int offset,
 *               int length)
 * 这个构造函数就可以，但是如果有中文，需要给出以何种方式进行构造-->
 *  public String(byte[] bytes,
 *               int offset,
 *               int length,
 *               Charset charset)
 *
 *  而相对于字符数组来说，就不要进行这样的转换，因为读取的时候，
 *  直接按照字符进行读取。这也就是代码中把从流中读到的数组转换
 *  成String对象时使用的方法不同的原因。
 */
public class InputSream_Reader {
    public static void main(String[] args){
        //demo1();
        //demo2();
        //demo3();
        demo4();
    }

    public static void demo1(){
        try {
            FileInputStream fis = new FileInputStream("zzz.txt");
            byte[] bytes = new byte[1024];
            int b=0;
            while ((b =fis.read())!=-1){
                System.out.println(b);            //这样子读出来的都是字节码196，156等
            }
            fis.close();
            System.out.println("============================================================");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo2(){
        try {
            FileInputStream fis = new FileInputStream("zzz.txt");
            byte[] bytes = new byte[1024];
            int b;
            StringBuffer sb =new StringBuffer();
            while ((b =fis.read(bytes))!=-1){                   //必须加上bytes
                sb.append(new String(bytes, 0, b, "utf-8"));
            }
            fis.close();
            System.out.println(sb);
            System.out.println("============================================================");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo3(){
        try {
            FileReader fis = new FileReader("zzz.txt");
            int b;
            while ((b =fis.read())!=-1){
                System.out.println((char) b);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //所使用的非Unicode语言不是系统的默认非Unicode语言
    public static void demo4(){
        try {
            FileInputStream in = new FileInputStream("必看.txt");
            InputStreamReader isr = new InputStreamReader(in,"GBK");
            //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试,指定码表读字符

            BufferedReader br = new BufferedReader(isr);
            String b;
            while ((b = br.readLine())!=null){
                System.out.println(b);
            }
            br.close();
            isr.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
