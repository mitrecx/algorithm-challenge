package cn.mitrecx;

/**
 * Title: 137. Single Number II
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 位运算
 */
public class LeetCode137 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2, 9, 9, 9};
        LeetCode137 leetCode137 = new LeetCode137();
        System.out.println(leetCode137.singleNumber(nums));
    }

    // 重复的数都是重复3次.
    // 按位算, 把所有数的n位(1=<n<=32) 加起来, 然后和3取余, 结果就是 不重复数 的 n位上的值.
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += num >> i & 1;
            }
            r += (sum % 3) << i;
        }
        return r;
    }
}
