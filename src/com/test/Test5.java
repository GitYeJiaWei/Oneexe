package com.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Test5 {
    public static void main(String[] args){
        //demo1();
        demo2();
    }

    /**
     * 将一个文本文档上的文本反转,第一行和倒数第一行交换,第二行和倒数第二行交换
     *
     * 分析:
     * 1,创建输入输出流对象
     * 2,创建集合对象
     * 3,将读到的数据存储在集合中
     * 4,倒着遍历集合将数据写到文件上
     * 5,关流
     *
     * 注意事项:
     * 流对象尽量晚开早关
     */
    public static void demo1(){
        try {
            //改写后是尽量晚开早关
            // 1,创建输入输出流对象
            BufferedReader br = new BufferedReader(new FileReader("ttt.txt"));

            //2,创建集合对象
            ArrayList<String> list = new ArrayList<>();
            //3,将读到的数据存储在集合中
            String line;
            while((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();											//关流

            //4,倒着遍历集合将数据写到文件上
            BufferedWriter bw = new BufferedWriter(new FileWriter("vv.txt"));
            for(int i = list.size() - 1; i >= 0; i--) {
                bw.write(list.get(i));
                bw.newLine();
            }
            //5,关流

            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo2(){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("zzz.txt"));
            HashMap<Character,Integer> map =new HashMap<>();

            int b;
            while ((b=bf.read())!=-1){
                char c =(char) b;

                map.put(c,!map.containsKey(c)?1:map.get(c)+1);
            }

            //5,创建输出流对象
            BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));
            //6,将结果写出
            for(Character key : map.keySet()) {
                switch (key) {
                    case '\t':
                        bw.write("\\t" + "=" + map.get(key));
                        break;
                    case '\n':
                        bw.write("\\n" + "=" + map.get(key));
                        break;
                    case '\r':
                        bw.write("\\r" + "=" + map.get(key));
                        break;
                    default:
                        bw.write(key + "=" + map.get(key)); 			//写出键和值
                        break;
                }
                bw.newLine();
            }

            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
