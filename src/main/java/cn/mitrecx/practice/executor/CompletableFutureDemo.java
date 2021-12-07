package cn.mitrecx.practice.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {

        test3();
    }

    public static void test1() throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println("异步任务......");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 执行完成后 往 CompletableFuture 对象里面写出返回值
            completableFuture.complete(Thread.currentThread().getName());
        }).start();

        System.out.println("main线程获取执行结果：" + completableFuture.get());
        for (int i = 1; i <= 3; i++) {
            System.out.println("main线程 - 输出：" + i);
        }
    }

    public static void test2() throws Exception {
        // 创建有返回值的异步任务
        CompletableFuture<String> supplyCF = CompletableFuture.supplyAsync(
                CompletableFutureDemo::evenNumbersSum);

        // 执行成功的回调
        supplyCF.thenAccept(System.out::println);

        // 执行过程中出现异常的回调
        supplyCF.exceptionally((e) -> {
            e.printStackTrace();
            return "异步任务执行过程中出现异常....";
        });

        // 因为如果不为CompletableFuture指定线程池执行任务的情况下，
        // CompletableFuture默认是使用ForkJoinPool.commonPool()的线程
        // 同时是作为main线程的守护线程进行的，如果main挂了，执行异步任
        // 务的线程也会随之终止结束，并不会继续执行异步任务
        for (int i = 1; i <= 10; i++) {
            System.out.println("main线程 - 输出：" + i);
            Thread.sleep(50);
        }

        /*************************************************/
        // 创建一个异步任务，已经给定返回值了
        CompletableFuture<String> c = CompletableFuture.completedFuture("竹子");
        c.thenApply(r -> {
            System.out.println("上个任务结果：" + r);
            return r + "...熊猫";
        });
        c.thenAccept(System.out::println);

        /***************************************************/

        // 创建一个没有返回值的异步任务
        CompletableFuture<Void> runCF = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 没有返回值的异步任务");
        });

        /***************************************************/

        // 创建单例的线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 创建一个有返回值的异步任务并指定执行的线程池
        CompletableFuture<String> supplyCFThreadPool =
                CompletableFuture.supplyAsync(CompletableFutureDemo::oddNumbersSum, executor);
        // // 执行过程中出现异常的回调
        supplyCFThreadPool.thenAccept(System.out::println);
        // 执行过程中出现异常的回调
        supplyCF.exceptionally((e) -> {
            e.printStackTrace();
            return "异步任务执行过程中出现异常....";
        });

        Thread.sleep(1000);
        // 关闭线程池
        executor.shutdown();
    }

    private static void test3() throws Exception {
        CompletableFuture<Void> cf =
                CompletableFuture.supplyAsync(CompletableFutureDemo::evenNumbersSum)
                        .thenApply(r -> { // 链式编程：基于上个任务的返回继续执行新的任务
                            System.out.println("获取上个任务的执行结果：" + r);
                            // 通过上个任务的执行结果完成计算：求和100所有数
                            return r + oddNumbersSum();
                        })
                        .thenApplyAsync(r -> {
                            System.out.println("获取上个任务的执行结果：" + r);
                            Integer i = Integer.parseInt(r) / 0; // 拋出异常
                            return r;
                        })
                        .handle((param, throwable) -> {
                            if (throwable == null) {
                                return Integer.parseInt(param) * 2;
                            }
                            // 获取捕获的异常
                            System.out.println("========" + throwable.getMessage());
                            System.out.println("我可以在上个任务抛出异常时依旧执行....");
                            return -1;
                        })
                        .thenCompose(x ->
                                CompletableFuture.supplyAsync(() -> x + 1))
                        .thenRun(() -> {
                            System.out.println("我是串行无返回任务....");
                        });
        // 主线程执行休眠一段时间
        // 因为如果不为CompletableFuture指定线程池执行任务的情况下，
        // CompletableFuture默认是使用ForkJoinPool.commonPool()的线程
        // 同时是作为main线程的守护线程进行的，如果main挂了，执行异步任
        // 务的线程也会随之终止结束，并不会继续执行异步任务
        Thread.sleep(2000);
    }

    // 求和100内的偶数
    private static String evenNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) sum += i;
        }
        return Thread.currentThread().getName() + "线程 - 100内偶数之和：" + sum;
    }

    // 求和100内的奇数
    private static String oddNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) sum += i;
        }
        return Thread.currentThread().getName() + "线程 - 100内奇数之和：" + sum;
    }
}