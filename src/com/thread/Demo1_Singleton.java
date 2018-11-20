package com.thread;

/**
 * * 单例设计模式：保证类在内存中只有一个对象。
 *
 * 单例的实现主要是通过以下两个步骤：
 *      1.将该类的构造方法定义为私有方法，这样其他处的代码就无法通过调用该类的构造方法来实例化该类的对象，
 *       只有通过该类提供的静态方法来得到该类的唯一实例；
 *      2.在该类内提供一个静态方法，当我们调用这个方法时，如果类持有的引用不为空就返回这个引用，
 *       如果类保持的引用为空就创建该类的实例并将实例的引用赋予该类保持的引用。
 */
public class Demo1_Singleton {
    public static void main(String[] args){
        //Singleton s1 = new Singleton();

        Singleton s1 = Singleton.s;				//成员变量被私有,不能通过类名.调用
        //Singleton.s = null;
        Singleton s2 = Singleton.s;

        System.out.println(s1 == s2);

	/*	Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2);*/
    }
}

/*
 * 饿汉式
class Singleton {
	//1,私有构造方法,其他类不能访问该构造方法了
	private Singleton(){}
	//2,创建本类对象
	private static Singleton s = new Singleton();
	//3,对外提供公共的访问方法
	public static Singleton getInstance() {				//获取实例
		return s;
	}
}*/
/*
 * 懒汉式,单例的延迟加载模式
 */
/*class Singleton {
	//1,私有构造方法,其他类不能访问该构造方法了
	private Singleton(){}
	//2,声明一个引用
	private static Singleton s ;
	//3,对外提供公共的访问方法
	public static Singleton getInstance() {				//获取实例
		if(s == null) {
			//线程1等待,线程2等待
			s = new Singleton();
		}

		return s;
	}
}*/

/*
 * 饿汉式和懒汉式的区别
 * 1,饿汉式是空间换时间,懒汉式是时间换空间
 * 2,在多线程访问时,饿汉式不会创建多个对象,而懒汉式有可能会创建多个对象
 */
class Singleton{
    //1,私有构造方法,其他类不能访问该构造方法了
    private Singleton(){}
    //2,声明一个引用
    public static final Singleton s = new Singleton();
}

/**
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次if (singleton == null)检查，
 * 这样就可以保证线程安全了。这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
 * 直接return实例化对象。
 *
 * 优点：线程安全；延迟加载；效率较高。
 */
class Singleton1 {

    private static volatile Singleton1 singleton1;

    private Singleton1() {}

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}