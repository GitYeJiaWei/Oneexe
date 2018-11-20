package com.NewJdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo1_Reflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IOException, InstantiationException {
        //demo1();
        demo2();
    }

    public static void demo1() throws ClassNotFoundException {
        Class clazz1 = Class.forName("com.NewJdk.Person_Bean");
        Class clazz2 = Person_Bean.class;

        Person_Bean p = new Person_Bean();
        Class clazz3 = p.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
    }

    /**
     * * 榨汁机(Juicer)榨汁的案例
     * 分别有水果(Fruit)苹果(Apple)香蕉(Banana)桔子(Orange)榨汁(squeeze)
     */
    public static void demo2() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Juicer j = new Juicer();

        BufferedReader br = new BufferedReader(
                new FileReader("config.properties"));
        Class clazz = Class.forName(br.readLine());
        Fruit f = (Fruit) clazz.newInstance();
        j.run(f);
    }
}

interface Fruit{
    public void squeeze();
}

class Apple implements Fruit{

    @Override
    public void squeeze() {
        System.out.println("苹果");
    }
}

class Orange implements Fruit{

    @Override
    public void squeeze() {
        System.out.println("橘子");
    }
}

class Juicer{
    public void run(Fruit t){
        t.squeeze();
    }
}
