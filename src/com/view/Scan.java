package com.view;

import java.util.Scanner;
/*在switch(expression)中，expression只能是一个整数表达式或者枚举常量，整数表达式可以是int类型或Integer包装类型。
由于，byte，short，char都可以隐式转换为int类型，所以，这些类型也可以用作表达式。
另外jdk7以后，switch表达式也可以为String类型,底层是调用的string.hashcode*/

public class Scan {
    public static void main(String args[]){
        Scanner scanner =new Scanner(System.in);

        int in = scanner.nextInt();
        if (in<10){
            System.out.println("小于10");
        }else if (in>=10 && in<50){
            System.out.println("大于10,小于50");
        }else{
            System.out.println("大于50");
        }

        String name = "rose";
        String gender = "妖";
        switch (gender) {
            case "男士":
                System.out.println(name + "是一位" + gender + "喜欢吃饭睡觉打dota");
                break;
            case "女士":
                System.out.println(name + "是一位" + gender + "喜欢逛街购物美容");
                break;
            default:
                System.out.println(name + "是一位" + gender + "打雌性激素维持美貌容颜");
                break;
        }

        for (int i = 1;i <= 4 ;i++ ) {					//外循环决定的是行数
            //循环体
            for (int j = 1;j <= 5 ;j++ ) {				//内循环决定的是列数
                System.out.print("*");
            }
            System.out.println();                       //换行
        }

        for (int i = 1;i <= 5 ; i++) {				//外循环决定行数
            for (int j = 1;j <= i ;j++ ) {			//内循环决定列数
                System.out.print("*");
            }
            System.out.println();					//将光标换到下一行的行首
        }
    }
}
