package com.ohterIO;

import java.util.Scanner;

public class Demo07_SystemIn {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line);
        sc.close();
    }
}
