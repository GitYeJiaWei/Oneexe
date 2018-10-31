package com.view;

/*数组定义格式
	数据类型[] 数组名 = new 数据类型[数组的长度]
	a:ArrayIndexOutOfBoundsException:数组索引越界异常
		* 原因：你访问了不存在的索引。
	* b:NullPointerException:空指针异常
		* 原因：数组已经不在指向堆内存了。而你还用数组名去访问元素。*/

public class Group {
    public static void main(String args[]){
        //定义一个数组,静态初始化
        int[] arr = {10,20,13,15,25,10,15};
        //数组遍历: 遍历是什么意思? 把数组中的每个元素一个个拿出来看一下
        //System.out.println(arr[0]);
        //arr.length 属性:数组名.length
        for (int i = 0;i < arr.length ;i++ ){  //数组中有多少个元素,我就帮你一个个打印出来 //细节 别写=号
            System.out.print(arr[i]+" "); //
        }
        System.out.println();

        int[] newArr =reverseArr(arr);
        for (int j = 0;j < newArr.length ;j++ )
        {
            System.out.print(newArr[j] + " ");
        }
        System.out.println();
        String a=chartostring("asfaklsdf");
        System.out.println(a);
    }

    public static int[] reverseArr(int[] oldArr){
        //思想
        //第一步 创建一个新的数组,然后长度和你传进来的数组长度一样
        //第二步 把旧的数组元素 从后面开始 往前一个个 存到新的数组里面
        int [] newArr = new int[oldArr.length];
        //newArr.toString().toCharArray();
        //第三步 遍历
        for (int i = 0;i < oldArr.length ;i++ )
        {
            newArr[i] = oldArr[oldArr.length - 1 - i];
        }
        return newArr;
		/*
		for (int j = 0;j < newArr.length ;j++ )
		{
			System.out.print(newArr[j] + " ");
		}*/

    }

    public static String chartostring(String verificationCode){
       /* for (int j =0;j<verificationCode.length();j++){
            char chars = verificationCode.charAt(j);
        }*/

       //需求：把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符),concat连接字符串
        String s = "woaiHEImaniaima";
        String s2 = s.substring(0, 1).toUpperCase().concat(s.substring(1).toLowerCase());
        System.out.println(s2);

        //把字符串string 转换成为 字符串数组char[]
        char[] chars1 =verificationCode.toCharArray();
        for (int i =0;i<chars1.length;i++){
            chars1[i] = isUpperCase(chars1[i]);
        }
        //再把chars1[]转换成string
        verificationCode = new String(chars1);

        return verificationCode;
    }

    //通过 ASCII 码判断字母大小写，ASCII在 65-90 之间是大写，97-122 是小写
    //通过 ASCII 加 32 转换为小写，减 32 转换为大写
    //或者通过CharCharacter.toLowerCase(c)转小写，Character.toUpperCase(c)转大写
    //转小写
    public  static char isUpperCase(char c){
        if (c>=65 && c<=90){
            c =Character.toLowerCase(c);
        }
        return c;
    }
    //转大写
    public  static char isLowerCase(char c){
        if (c>=97 && c<=122){
            c= Character.toUpperCase(c);
        }
        return c;

    }



}
