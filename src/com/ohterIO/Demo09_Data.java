package com.ohterIO;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo09_Data {
    public static void main(String[] args){
        demo3();
    }

    public static void demo3(){
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("wtx.txt"));
            dos.write(997);
            dos.write(998);
            dos.write(999);
            dos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
