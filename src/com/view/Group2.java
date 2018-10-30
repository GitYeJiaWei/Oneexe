package com.view;
/*需求：二维数组遍历

 * 外循环控制的是二维数组的长度，其实就是一维数组的个数。
 * 内循环控制的是一维数组的长度。*/
public class Group2 {
    public static void main(String[] args){
        char[][] chars = new char[5][5];
        int[][] arrs = new int[3][3];
        int[][] arr = {{1,2,3},{4,5},{6,7,8,9}}; //这是一个二维数组,这个二维数组中每个大括号都代表一个一维数组

        for (int i = 0;i < arr.length ;i++ ) {			//获取到每个二维数组中的一维数组
            for (int j = 0;j < arr[i].length ;j++ ) {	//获取每个一维数组中的元素
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
