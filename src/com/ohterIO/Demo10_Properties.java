package com.ohterIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties是Hashtable的子类
 */
public class Demo10_Properties {
    public static void main(String[] args){
        //demo1();
        //demo2();
        demo3();
    }

    public static void demo1(){
        Properties prop = new Properties();
        prop.put("key","1234");
        System.out.println(prop);
    }

    public static void demo2() {
        Properties prop = new Properties();
        prop.setProperty("name", "张三");
        prop.setProperty("tel", "18912345678");

        //System.out.println(prop);
        Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
        while(en.hasMoreElements()) {
            String key = en.nextElement();				//获取Properties中的每一个键
            String value = prop.getProperty(key);		//根据键获取值
            System.out.println(key + "="+ value);
        }
    }

    public static void demo3(){
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));		//将文件上的键值对读取到集合中
            prop.setProperty("tel1", "18912345678");
            prop.store(new FileOutputStream("config.properties"), null);//第二个参数是对列表参数的描述,可以给值,也可以给null
            System.out.println(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
