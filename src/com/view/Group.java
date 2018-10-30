package com.view;

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
    }

    public static int[] reverseArr(int[] oldArr){
        //思想
        //第一步 创建一个新的数组,然后长度和你传进来的数组长度一样
        //第二步 把旧的数组元素 从后面开始 往前一个个 存到新的数组里面
        int [] newArr = new int[oldArr.length];
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


}
