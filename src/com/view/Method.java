package com.view;

public class Method {
    public static void main(String args[]){
        int sum = add(10,30);
        int big = isbig(30,35);
        System.out.println(sum);
        System.out.println(big);
    }

    public static int add(int a,int b){
        return a+b;
    }

    //a大于b返回a否则返回b
    public static int isbig(int a,int b){
        return a>b?a:b;
    }
}
