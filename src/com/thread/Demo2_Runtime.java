package com.thread;

import java.io.IOException;

public class Demo2_Runtime {
    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();			//获取运行时对象
        //r.exec("shutdown -s -t 300");             //windows会在5分钟后关机
        r.exec("shutdown -a");           //停止关机
    }
}
