package com.thread1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo3_Thread有返回值的线程
 * Demo4_Thread无返回值的线程
 */

/**
 * execute 和 submit的区别
 * 1、接受的参数（任务类型）不一样
 * execute只能接受Runnable类型的任务
 * submit不管是Runnable还是Callable类型的任务都可以接受，但是Runnable返回值均为void，所以使用Future的get()获得的还是null
 *
 * 2、返回值
 * execute没有返回值
 * submit有返回值，所以需要返回值的时候必须使用submit
 */
public class Demo4_Thread{
    private static int MAX_THREAD = 10;//最大线程数

    public static void main(String[] args) throws ExecutionException,
            InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < MAX_THREAD; i++) {
            RunableMy runableMy = new RunableMy();
            Thread.sleep(1000);
            //添加线程进入队列
            executorService.execute(runableMy);
        }
        //关闭线程池
        executorService.shutdown();
    }
}

class RunableMy implements Runnable{
    public void run(){
        System.out.println("通过线程池方式创建的线程："+Thread.currentThread().getName());
    }
}
