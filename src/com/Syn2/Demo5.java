package com.Syn2;

/**
 * syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。
 * 这是因为run中调用了静态方法method，而静态方法是属于类的，
 * 所以syncThread1和syncThread2相当于用了同一把锁。这与Demo1是不同的
 */
public class Demo5 {
    public static void main(String[] args){
        Synch syncThread1 = new Synch();
        Synch syncThread2 = new Synch();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

/**
 * 同步线程
 */
class Synch implements Runnable{
    private static int count;
    public Synch(){
        count = 0;
    }

    public synchronized static void method(){
        for (int i = 0; i < 7; i++) {
            System.out.println(Thread.currentThread().getName()+":"+count++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void run() {
        method();
    }
}
