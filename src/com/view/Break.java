package com.view;
/*break的使用场景
 * 只能在switch和循环中
 *
 * continue的使用场景
 * 只能在循环中 */

public class Break {
    public static void main(String args[]){
        for (int i=0;i<4;i++){
            if (i==2){
                //break;                        //跳出循环
                return;							//返回的意思,用来返回方法，下面的方法不执行
            }
            System.out.print(i+" ");
        }
        System.out.println("----");

        for (int x = 1;x <= 10 ;x++ ) {
            if (x == 4) {
                //break;
                continue;							//终止本次循环,继续下次循环
            }

            System.out.println("x = " + x);
        }
        System.out.println("----");
    }
}
