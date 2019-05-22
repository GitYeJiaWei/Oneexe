package com.thread1;


import java.util.concurrent.*;

public class Demo_ThreadPoolExecutor extends ThreadPoolExecutor{
    /**
     * 1.corePoolSize
     * 程池中的核心线程数，也就是是线程池中的最小线程数;
     * 核心线程在allowCoreThreadTimeout被设置为true时会超时退出，默认情况下不会退出;
     *
     * 2.maximumPoolSize
     * 最大线程池大小,当活动线程数达到这个值，后续任务会被阻塞
     *
     * 3.keepAliveTime
     * 线程池中超过corePoolSize数目的非核心线程最大存活时间；闲置时的超时时长，超过这个值后，闲置线程就会被回收
     *
     * 4.unit
     * keepAliveTime 参数的时间单位。这是一个枚举，详情请参考TimeUnit
     *
     * 5.workQueue
     * 执行前用于保持任务的队列，也就是线程池的缓存队列。此队列仅保持由 execute 方法提交的 Runnable 任务
     *
     * 6.threadFactory
     * 线程工厂，为线程池提供创建新线程的功能，它是一个接口，只有一个方法：Thread newThread(Runnable r)
     *
     * 7.RejectedExecutionHandler
     * 线程池对拒绝任务的处理策略。一般是队列已满或者无法成功执行任务，这时ThreadPoolExecutor会调用handler的rejectedExecution方法来通知调用者
     * */
    public Demo_ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public Demo_ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public Demo_ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public Demo_ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    /**
     * ThreadPoolExecutor默认有四个拒绝策略：
     *   1、ThreadPoolExecutor.AbortPolicy()   直接抛出异常RejectedExecutionException
     *   2、ThreadPoolExecutor.CallerRunsPolicy()    直接调用run方法并且阻塞执行
     *   3、ThreadPoolExecutor.DiscardPolicy()   直接丢弃后来的任务
     *   4、ThreadPoolExecutor.DiscardOldestPolicy()  丢弃在队列中队首的任务
     *
     */

}
