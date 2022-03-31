package cn.mitrecx;

/**
 * Title: 190. Reverse Bits
 * Difficulty: Easy
 * Self Difficulty:
 * kw:
 */
public class LeetCode190 {
    public static void main(String[] args) {
        LeetCode190 leetCode190 = new LeetCode190();
        System.out.println(leetCode190.reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return r;
    }
}
