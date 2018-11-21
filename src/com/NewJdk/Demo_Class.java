package com.NewJdk;


/**
 * Class类，是获取类的类模板实例对象，通过反射的机制获取。
 *
 * 根据API中的定义：
 *
 * Class.getName()：以String的形式，返回Class对象的“实体”名称；
 *
 * Class.getSimpleName()：获取源代码中给出的“底层类”简称。
 */
public class Demo_Class {
    private static final String TAG1 = Demo_Class.class.getName();
    private static final String TAG2 = Demo_Class.class.getSimpleName();

    public static void main(String[] args) {
        System.out.println("getName ----- " + TAG1 + "\n" + "getSimpleName ----- " + TAG2);
    }
}

//getName ----“实体名称” ---- com.NewJdk.Demo_Class
//getSimpleName ---- “底层类简称” ---- Demo_Class
//getName() 获取包名+类名； getSimpleName() 获取类名；