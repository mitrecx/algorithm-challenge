package cn.mitrecx.leetcode1_200;

/**
 * <a href="https://leetcode.com/problems/single-number/">Title: 136. Single Number</a>
 * <p> Difficulty: Easy
 * <p> Self Difficulty:
 * <p> kw: 位运算, 异或(^)运算
 * <p>
 * A ^ B 结果: 相异为 1, 相同为 0.
 * <p>
 * 0 ^ A = A,
 * A ^ A = 0
 * <p>
 * 异或运算满足 交换律 和 结合律.
 */
public class LeetCode136 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        LeetCode136 leetCode136 = new LeetCode136();
        System.out.println(leetCode136.singleNumber(nums));
    }

    // 异或运算(^): 相同为0, 相异为1.
    // a^a=0;
    // a^0=a;
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r = r ^ num;
        }
        return r;
    }
}
