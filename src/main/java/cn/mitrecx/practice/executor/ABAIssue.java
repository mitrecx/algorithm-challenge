package cn.mitrecx.practice.executor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABAIssue {
    // 定义原子计数器，初始值 = 100
    private static AtomicInteger atomicI = new AtomicInteger(100);
    // 定义AtomicStampedReference：初始化时需要传入一个初始值和初始时间
    private static AtomicStampedReference<Integer> asRef = new AtomicStampedReference<Integer>(100, 0);

    /**
     * 未使用AtomicStampedReference线程组：TA TB
     */
    private static Thread TA = new Thread(() -> {
        System.err.println("未使用AtomicStampedReference线程组：[TA TB] >>>>");
        // 更新值为101
        boolean flag = atomicI.compareAndSet(100, 101);
        System.out.println("线程TA：100 -> 101.... flag:" + flag + ",atomicINewValue：" + atomicI.get());
        // 更新值为100
        flag = atomicI.compareAndSet(101, 100);
        System.out.println("线程TA：101 -> 100.... flag:" + flag + ",atomicINewValue：" + atomicI.get());
    });
    private static Thread TB = new Thread(() -> {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean flag = atomicI.compareAndSet(100, 888);
        System.out.println("线程TB：100 -> 888.... flag:" + flag + ",atomicINewValue：" + atomicI.get() + "\n\n");
    });

    /**
     * 使用AtomicStampedReference线程组：T1 T2
     */
    private static Thread T1 = new Thread(() -> {
        System.err.println("使用AtomicStampedReference线程组：[T1 T2] >>>>");
        // 更新值为101
        boolean flag = asRef.compareAndSet(100, 101, asRef.getStamp(), asRef.getStamp() + 1);
        System.out.println("线程T1：100 -> 101.... flag:" + flag +
                ".... asRefNewValue:" + asRef.getReference() + ".... 当前Time：" + asRef.getStamp());
        // 更新值为100
        flag = asRef.compareAndSet(101, 100, asRef.getStamp(), asRef.getStamp() + 1);
        System.out.println("线程T1：101 -> 100.... flag:" + flag +
                ".... asRefNewValue:" + asRef.getReference() + ".... 当前Time：" + asRef.getStamp());
    });

    private static Thread T2 = new Thread(() -> {
        int time = asRef.getStamp();
        System.out.println("线程休眠前Time值：" + time);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean flag = asRef.compareAndSet(100, 888, time, time + 1);

        System.out.println("线程T2：100 -> 888.... flag:" + flag + ".... asRefNewValue:" + asRef.getReference() + ".... 当前Time：" + asRef.getStamp());
    });

    public static void main(String[] args) throws InterruptedException {
        TA.start();
        TB.start();
        TA.join();
        TB.join();

        T1.start();
        T2.start();
    }
}