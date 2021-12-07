package cn.mitrecx.thread;

public class TempTest {
    public void bitTest() {
        StringBuilder sb = new StringBuilder("hello world");
        StringBuilder sb2 = sb;
        if (sb == sb2) {
            System.out.println("Heap addresses are identical.");
        }
        System.gc();
        System.out.println("After gc, still strongly reachable[2], sb2: " + sb2);
        sb = null;
        System.gc();
        System.out.println("After gc, still strongly reachable[1], sb2: " + sb2);
        sb2 = null;
        System.gc();
        System.out.println("After gc, unreachable[0], sb2: " + sb2);
    }

    public static void main(String[] args) {
        TempTest tempTest = new TempTest();
        System.out.println(tableSizeFor(5));
        System.out.println(tableSizeFor(6));
        System.out.println(tableSizeFor(7));
        System.out.println(tableSizeFor(8));
        System.out.println(tableSizeFor(9));
    }
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
