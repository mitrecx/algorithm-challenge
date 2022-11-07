package cn.mitrecx.leetcode1_200;

import java.util.Arrays;

/**
 * 66. Plus One
 */
public class LeetCode66 {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        LeetCode66 leetCode66 = new LeetCode66();
        System.out.println(Arrays.toString(leetCode66.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 从最低位 往 最高位遍历, 找第一个非9的数(不用进位)
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        // 没找到, 说明全是9
        int[] r = new int[digits.length + 1];
        r[0] = 1;
        return r;
    }
}
