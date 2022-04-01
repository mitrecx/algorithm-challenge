package cn.mitrecx.utils;

/**
 *
 */
public class LeetCodeUtils {
    public static void main(String[] args) {
        System.out.println(toBinaryString(-1));
        System.out.println(toBinaryString(-1>>>30));
        // The shift distance actually used is therefore always in the range 0 to 31, inclusive.
        // that is -1 >>> 32 is equivalent to -1 >>> 0 and -1 >>> 33 is equivalent to -1 >>> 1
        System.out.println(-1>>>32);
    }

    public static String toBinaryString(int num) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int bit = (num & (0x80000000 >>> i)) >>> (31 - i);
            r.append(bit);
            /*
            if ((i + 1) % 8 == 0) {
                r.append(" ");
            }
            */
        }
        return r.toString();
    }
}
