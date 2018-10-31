package com.view;
/*equals方法，比较两个对象是否相等
	 * public boolean equals(Object obj){
	 *    return (this == obj);
	 * }
	 *
	 * Object中的equals方法是比较对象的地址值，没有什么意义，我们 需要重写它。
	 * 因为在开发中我们通常比较的是对象中的属性值，我们认为 相同属性是同一个对象，这样我们就需要重写equals方法。

	   ==和equals方法的区别
	       共同点：都可以做比较，返回值都是boolean
	        区别：1，==是比较运算符号,既可以比较基本数据类型,也可以比较引用数据类型,基本数据类型比较的是值,引用数据类型比较的是地址值
	 	    2，equals方法只能比较引用数据类型,equals方法在没有重写之前,比较的是地址值，底层依赖的是==号，但是比较地址值是没
	 	               有意义的，我们需要重写equals方法比较对象中的属性值。*/
public class Equals {
    public static void main(String[] args){
        Student s1 =  new Student("张三", 23);
        Student s2 =  new Student("张三", 23);
        boolean b = s1.equals(s2);   			//比较2个对象是否相等
        System.out.println(s1 == s2);
        System.out.println(b);					//重写之后比较的是对象中的属性值

        Object object = new Object();
        int hashcode = object.hashCode();
        System.out.println(hashcode);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        Class c =s1.getClass();
        String name = c.getName();
        System.out.println(name);

        /*demo1();
        demo2();
        demo3();
        demo4();*/
        demo5();
    }

    private static void demo1() {				//常量池中没有这个字符串对象,就创建一个,如果有直接用即可
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); 			//true 比的是地址值
        System.out.println(s1.equals(s2)); 		//true 比的是内容值
    }

    private static void demo2() {
        //创建几个对象
        //创建两个对象,一个在常量池中,一个在堆内存中
        String s1 = new String("abc");
        System.out.println(s1);
    }

    private static void demo4() {
        //byte b = 3 + 4;						//在编译时就变成7,把7赋值给b,常量优化机制
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2); 			//true,java中有常量优化机制
        System.out.println(s1.equals(s2)); 		//true
    }

    private static void demo3() {
        String s1 = new String("abc");			//记录的是堆内存对象的地址值
        String s2 = "abc";						//记录的是常量池中的地址值
        System.out.println(s1 == s2); 			//false
        System.out.println(s1.equals(s2)); 		//true
    }

    private static void demo5(){
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        String s4 = "ab"+"c";
        System.out.println(s3 == s2);           //false s3相当于创建了一个new string,一个是堆地址，一个是常量地址
        System.out.println(s4 == s2);           //编辑器对常量进行了整合，
        System.out.println(s3);
        System.out.println(s3.equals(s2)); 		//true
    }

    private static void demo6() {
        String s1 = "我爱heima,哈哈";
        String s2 = "heima";
        String s3 = "baima";
        String s4 = "我爱";
        String s5 = "哈哈";

        System.out.println(s1.contains(s2));		//判断是否包含传入的字符串
        System.out.println(s1.contains(s3));

        System.out.println("------------------");
        System.out.println(s1.startsWith(s4));		//判断是否以传入的字符串开头
        System.out.println(s1.startsWith(s5));

        System.out.println("------------------");
        System.out.println(s1.endsWith(s4));		//判断是否以传入的字符串结尾
        System.out.println(s1.endsWith(s5));

        String s11 = "heima";
        String s21 = "heima";
        String s31 = "HeiMa";

        System.out.println(s11.equals(s21));		//true
        System.out.println(s21.equals(s31));		//false

        System.out.println("---------------");

        System.out.println(s11.equalsIgnoreCase(s21));
        System.out.println(s11.equalsIgnoreCase(s31)); 	//不区分大小写
    }

}
