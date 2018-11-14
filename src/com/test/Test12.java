package com.test;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *  需求:求出1000的阶乘所有零和尾部零的个数
 *  获取幸运数字
 */
public class Test12 {
    public static void main(String[] args){
        demo1();
        System.out.println(demo2(1000));
        System.out.println(getLucklyNum(10));
    }

    public static int demo2(int num) {
        if(num > 0 && num < 5) {
            return 0;
        }else {
            return num / 5 + demo2(num / 5);
        }
    }

    public static void demo1() {		//求1000的阶乘中所有的零
        BigInteger bi1 = new BigInteger("1");
        for(int i = 1; i <= 1000; i++) {
            BigInteger bi2 = new BigInteger(i+"");
            bi1 = bi1.multiply(bi2);	//将bi1与bi2相乘的结果赋值给bi1
        }
        String str = bi1.toString();	//获取字符串表现形式
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if('0' == str.charAt(i)) {	//如果字符串中出现了0字符
                count++;				//计数器加1
            }
        }
        System.out.println(count);
    }

    /*
     * 获取幸运数字
     * 1,返回值类型int
     * 2,参数列表int num
     */
    public static int getLucklyNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();		//创建集合存储1到num的对象
        for(int i = 1; i <= num; i++) {
            list.add(i);									//将1到num存储在集合中
        }

        int count = 1;										//用来数数的,只要是3的倍数就杀人
        for(int i = 0; list.size() != 1; i++) {				//只要集合中人数超过1,就要不断的杀
            if(i == list.size()) {							//如果i增长到集合最大的索引+1时
                i = 0;										//重新归零
            }

            if(count % 3 == 0) {							//如果是3的倍数
                list.remove(i--);								//就杀人
            }
            count++;
        }

        return list.get(0);
    }
}
