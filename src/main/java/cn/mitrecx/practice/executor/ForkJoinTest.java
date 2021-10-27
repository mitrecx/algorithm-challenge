package cn.mitrecx.practice.executor;

import java.util.concurrent.*;

public class ForkJoinTest {
    static class PrintTask extends RecursiveAction {
        private static final int THRESHOLD = 2;
        private int start;
        private int end;

        public PrintTask(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                for (int i = start; i <= end; i++) {
                    System.out.println(Thread.currentThread().getName() + ",i=" + i);
                }
            } else {
                int middle = (start + end) / 2;
                PrintTask firstTask = new PrintTask(start, middle);
                PrintTask secondTask = new PrintTask(middle + 1, end);
                RecursiveAction.invokeAll(firstTask, secondTask);
            }
        }
    }

    static class CalculateTask extends RecursiveTask<Integer> {

        private static final long serialVersionUID = 1L;
        private static final int THRESHOLD = 49;
        private int start;
        private int end;

        public CalculateTask(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {
            if (end - start <= THRESHOLD) {
                int result = 0;
                for (int i = start; i <= end; i++) {
                    result += i;
                }
                return result;
            } else {
                int middle = (start + end) / 2;
                CalculateTask firstTask = new CalculateTask(start, middle);
                CalculateTask secondTask = new CalculateTask(middle + 1, end);
                RecursiveTask.invokeAll(firstTask, secondTask);
                return firstTask.join() + secondTask.join();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        testNoResultTask();
        // ==
        System.out.println("=====");
        testHasResultTask();
    }

    private static void testNoResultTask() throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(1, 10));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }

    public static void testHasResultTask() throws Exception {
        int result1 = 0;
        for (int i = 1; i <= 1000000; i++) {
            result1 += i;
        }
        System.out.println("循环计算 1-1000000 累加值：" + result1);

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new CalculateTask(1, 1000000));
        int result2 = task.get();
        System.out.println("并行计算 1-1000000 累加值：" + result2);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }

}
