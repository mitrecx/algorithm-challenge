package cn.mitrecx.leetcode1_200;

import cn.mitrecx.utils.LeetCodeUtils;

/**
 * Title: 190. Reverse Bits
 * Difficulty: Easy
 * Self Difficulty:
 * kw:
 */
public class LeetCode190 {
    public static void main(String[] args) {
        LeetCode190 leetCode190 = new LeetCode190();
        int arg = 43261596;
        System.out.println(LeetCodeUtils.toBinaryString(arg));
        int r = leetCode190.reverseBits(arg);
        System.out.println(LeetCodeUtils.toBinaryString(r));
        System.out.println(r);
    }

    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r |= (n & 1) << (31 - i);
            // unsigned right shift operator >>>
            n >>>= 1;
        }
        return r;
    }
}
