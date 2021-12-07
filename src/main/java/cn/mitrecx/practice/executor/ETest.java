package cn.mitrecx.practice.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ETest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       int rs = resizeStamp(8);

    }

    private static int RESIZE_STAMP_BITS = 16;

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
    }
}
