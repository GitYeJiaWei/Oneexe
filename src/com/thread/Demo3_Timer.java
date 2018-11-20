package com.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        //在指定时间安排指定任务
        //第一个参数,是安排的任务,第二个参数是从调用schedule到执行第一次时延迟的时间,第三个参数是过多长时间再重复执行
        timer.schedule(new MyT(), 3000,3000);

        while(true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}

class MyT extends TimerTask{

    @Override
    public void run() {
        System.out.println("this is timertask");
    }
}
