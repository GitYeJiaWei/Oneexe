package com.Syn2;

/**
 * synchronized是Java中的关键字，是一种同步锁。它修饰的对象有以下几种：
 * 1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 * 2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
 * 3. 修饰一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
 * 4. 修饰一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
 */

/**
 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，
 * 则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
 * B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
 * C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制
 */

/**
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 *
 * demo1 到demo3为修饰代码块
 * demo4是修饰方法
 * demo5是修饰静态方法
 * demo6是修饰类
 */
public class Demo1 {
    public static void main(String[] args){
        sysnc sys = new sysnc();
        Thread thread1 = new Thread(sys,"thread1");
        Thread thread2 = new Thread(sys,"thread2");
        //thread1.start();
        //thread2.start();
        /**
         * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
         * 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。
         *  hread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，
         *  只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象
        */

        Thread thread3 = new Thread(new sysnc(),"thread3");
        Thread thread4 = new Thread(new sysnc(),"thread4");
        thread3.start();
        thread4.start();
        /**
         * 这时创建了两个SyncThread的对象syncThread1和syncThread2，
         * 线程thread1执行的是syncThread1对象中的synchronized代码(run)，
         * 而线程thread2执行的是syncThread2对象中的synchronized代码(run)；我
         * 们知道synchronized锁定的是对象，这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
         * 而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行
         */
    }
}

class sysnc implements Runnable{
    private int count;
    public sysnc(){
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+":"+(count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

