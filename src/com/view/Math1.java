package com.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Math1 {
    /**
     * @param args
     * * A:Math类概述
     * Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。
     * B:成员方法
     * public static int abs(int a)
     * public static double ceil(double a)
     * public static double floor(double a)
     * public static int max(int a,int b) min自学
     * public static double pow(double a,double b)
     * public static double random()
     * public static int round(float a) 参数为double的自学
     * public static double sqrt(double a)
     * 在一个源文件中不允许定义两个用public修饰的类
     */
    public static void main(String[] args){
        System.out.println(Math.PI);                    //3.1415926
        System.out.println(Math.abs(-10));  			//取绝对值,10

        //ceil天花板
        System.out.println(Math.ceil(12.3));			//向上取整,但是结果是一个double,13.0
        System.out.println(Math.ceil(12.99));           //13.0

        System.out.println("-----------");
        //floor地板
        System.out.println(Math.floor(12.3));			//向下取整,但是结果是一个double,12.0
        System.out.println(Math.floor(12.99));          //12.0

        //获取两个值中的最大值,30
        System.out.println(Math.max(20, 30));

        //前面的数是底数,后面的数是指数,8.0
        System.out.println(Math.pow(2, 3));				//2.0 ^ 3.0

        //生成0.0到1.0之间的所以小数,包括0.0,不包括1.0
        System.out.println(Math.random());
        Math.random();

        //四舍五入
        System.out.println(Math.round(12.3f));
        System.out.println(Math.round(12.9f));
        Math.round(12.6);

        //开平方
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(2));
        System.out.println(Math.sqrt(3));

        System.out.println("-----------");
        demo2();
    }

    public static void demo1(){
        Random r = new Random();
		int x = r.nextInt();

		System.out.println(x);

        for(int i = 0; i < 10; i++) {
            //System.out.println(r.nextInt());
            System.out.println(r.nextInt(100));			//要求掌握,生成在0到n范围内的随机数,包含0不包含n
            r.nextInt(100);
        }
    }

    public static void demo2(){
        long starttime = System.currentTimeMillis();
        for (int i =0;i<1000;i++){
            System.out.println("*");
        }
        long endtime = System.currentTimeMillis();  //获取当前时间的毫秒值
        System.out.println(endtime);
        System.out.println(endtime -starttime);

        Date d1 = new Date();					//如果没有传参数代表的是当前时间
        System.out.println(d1);

        Date d2 = new Date(0);					//如果构造方法中参数传为0代表的是1970年1月1日
        System.out.println(d2);					//通过毫秒值创建时间对象

        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(d1));

        Calendar c = Calendar.getInstance();		//父类引用指向子类对象
        System.out.println(c.get(Calendar.YEAR));		//通过字段获取年
        System.out.println(c.get(Calendar.MONTH));		//通过字段后期月,但是月是从0开始编号的
        System.out.println(c.get(Calendar.DAY_OF_MONTH));//月中的第几天
        System.out.println(c.get(Calendar.DAY_OF_WEEK));//周日是第一天,周六是最后一天

        System.out.println(c.get(Calendar.YEAR) + "年" + getNum((c.get(Calendar.MONTH)+1))
                + "月" + getNum(c.get(Calendar.DAY_OF_MONTH)) + "日" + getWeek(c.get(Calendar.DAY_OF_WEEK)));

        System.exit(1);							//非0状态是异常终止,退出jvm
    }

    /*
     * 将星期存储表中进行查表
     * 1,返回值类型String
     * 2,参数列表int week
     */

    public static String getWeek(int week) {
        String[] arr = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

        return arr[week];
    }

    /*
     * 如果是个数数字前面补0
     * 1,返回值类型String类型
     * 2,参数列表,int num
     */
    public static String getNum(int num) {
		/*if(num > 9) {
			return "" + num;
		}else {
			return "0" + num;
		}*/
        return num > 9 ? "" + num : "0" + num;
    }

    public static void demo3(){
        int[] src ={11,32,45,66,23};
        int[] dex = new int[8];
        for (int i=0;i<dex.length;i++){
            System.out.println(dex[i]);
        }

        System.out.println("--------------------------");
        System.arraycopy(src, 0, dex, 0, src.length);		//将数组内容拷贝

        for (int i = 0; i < dex.length; i++) {
            System.out.println(dex[i]);
        }
    }

}
