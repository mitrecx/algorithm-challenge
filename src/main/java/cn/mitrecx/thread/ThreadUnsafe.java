package cn.mitrecx.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadUnsafe {
    public static List<Integer> numberList = new ArrayList<>();

    public static class AddToList implements Runnable {
        @Override
        public void run() {
            int count = 1;
            while (count <= 100) {
                numberList.add(1);
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddToList());
        Thread t2 = new Thread(new AddToList());
        t1.start();
        t2.start();
        Thread.sleep(4000);

        System.out.println(numberList.size());
    }
}
