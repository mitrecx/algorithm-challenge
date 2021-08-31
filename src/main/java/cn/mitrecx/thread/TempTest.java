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
        tempTest.bitTest();
    }
}
