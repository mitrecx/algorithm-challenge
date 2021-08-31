package cn.mitrecx.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread.");
        }
    }
    final String str = "hhlo";
    static class RunnableTask implements Runnable {
        User u;

        public RunnableTask(User u) {
            this.u = u;
        }

        public void setU(User u) {
            this.u = u;
        }

        public RunnableTask() {
        }

        @Override
        public void run() {
            System.out.println(u);
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        String s = "hello";
        User u = new User("001", "mitre", 12);
        Thread t2 = new Thread(() -> {
            System.out.println(s);
            System.out.println(u);
            System.out.println("new child thread.");
        });
        t2.start();
        Thread t3  = new Thread(new  RunnableTask(u));
        t3.start();
        FutureTask<String> futureTask = new FutureTask<>(()-> "hello");
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
