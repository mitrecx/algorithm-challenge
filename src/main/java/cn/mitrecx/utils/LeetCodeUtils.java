package cn.mitrecx.utils;

/**
 *
 */
public class LeetCodeUtils {
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
