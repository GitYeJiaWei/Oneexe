package com.view;

/*基本数据类型包装类有八种,其中七种都有parseXxx的方法,可以将这七种的字符串表现形式转换成基本数据类型*/
public class IntegerInt {
    public static void main(String[] args){
        //int ----> String int转换成String
        int i = 100;
        String s1 = i + "";						//推荐用
        String s2 = String.valueOf(i);			//推荐用

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //Integer i2 = new Integer("abc");			//java.lang.NumberFormatException数字格式异常
        //System.out.println(i2);						//因为abc不是数字字符串,所以转换会报错

        int c = Integer.parseInt("123");       //将String转换为int,推荐用这种
        System.out.println(c);

        Integer i2 = 100;						//自动装箱,把基本数据类型转换成对象
        int z = i2 + 200;						//自动拆箱,把对象转换为基本数据类型
        System.out.println(z);
    }

}
