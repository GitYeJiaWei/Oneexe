package com.syn;

/**
 * 火车站卖票的例子用实现Runnable接口
 */
public class Demo2_Ticket {
    public static void main(String[] args){
        Ticket ti = new Ticket();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        
    }
}

class Ticket extends Thread{
    private static int ticket = 100;
    public void print(){
        while (true) {

            synchronized (Ticket.class){
                if(ticket <= 0) {
                    break;
                }
                try {
                    Thread.sleep(10);				//线程1睡,线程2睡,线程3睡,线程4睡
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                System.out.println(getName() + "...这是第" + ticket-- + "号票");
            }
        }
    }
}
