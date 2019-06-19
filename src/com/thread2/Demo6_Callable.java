package com.thread2;

import java.util.concurrent.*;

/**
 *   （1）Callable规定的方法是call()，而Runnable规定的方法是run().
 *   （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
 *   （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
 *   （4）运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。
 *   它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
 *   通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。
 * Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。
 */
public class Demo6_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);//创建线程池
        Future<Integer> f1 = pool.submit(new MyCallable(100));                //将线程放进池子里并执行
        Future<Integer> f2 = pool.submit(new MyCallable(50));
        Future<Boolean> f3 = pool.submit(new YouCallable());

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

        pool.shutdown();                            //关闭线程池
    }

    static class MyCallable implements Callable<Integer> {
        private int num;

        public MyCallable(int num) {
            this.num = num;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
            }

            return sum;
        }
    }

    static class YouCallable implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {

            return false;
        }
    }
}


