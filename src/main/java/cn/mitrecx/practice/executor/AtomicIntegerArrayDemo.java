package cn.mitrecx.practice.executor;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray atomicArr = new AtomicIntegerArray(5);

    public static class incrementTask implements Runnable {
        public void run() {
            // 执行数组中元素自增操作,参数为index,即数组下标
            for (int i = 0; i < 100; i++)
                atomicArr.getAndIncrement(i % atomicArr.length());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++)
            threads[i] = new Thread(new incrementTask());

        for (int i = 0; i < 5; i++)
            threads[i].start();

        for (int i = 0; i < 5; i++)
            threads[i].join();
        System.out.println(atomicArr);

    }
}
