package com.Syn2;

public class Demo2 {
    public static void main(String[] args) {
        Account account = new Account("zhang san", 1500.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(accountOperator, "thread" + i);
            threads[i].start();
        }
        /**
         * 在AccountOperator 类中的run方法里，我们用synchronized 给account对象加了锁。
         * 这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，
         * 直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。
         */
    }
}

/**
 * 银行账户类
 */
class Account {
    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    //存钱
    public void deposit(float amt) {
        amount += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //取钱
    public void withdraw(float amt) {
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amount;
    }
}

/**
 * 账户操作类
 */
class AccountOperator implements Runnable {
    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        //锁定对象
        synchronized (account) {
            account.deposit(400);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }

    public void method3(Object obj)
    {
        //obj 锁定的对象
        synchronized(obj)
        {
            // todo
        }
    }
}

/**
 * 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁：
 * 说明：零长度的byte数组对象创建起来将比任何对象都经济――查看编译后的字节码：
 * 生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码
 */
class Test implements Runnable {
    private byte[] lock = new byte[0];  // 特殊的instance变量

    public void method() {
        synchronized (lock) {
            // todo 同步代码块
        }
    }

    public void run() {

    }
}
