package com.lfeng.threadlocaldemo.threadlocal;

/**
 * @createTime:2021-04-04 01:32:30
 * @author:luofeng30850
 * @description:threadlocal
 */
public class Concurrent01 {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set(0);
            System.out.println(threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set(1);
            System.out.println(threadLocal.get());
        });
        t1.start();
        t2.start();
    }

    //git push -u origin master -f
}
