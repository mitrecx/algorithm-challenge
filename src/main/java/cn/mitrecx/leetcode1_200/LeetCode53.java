package cn.mitrecx.leetcode1_200;

/**
 * Title: 53. Maximum Subarray
 * Difficulty: Easy
 * Self Difficulty: 下
 * kw: 动态规划/贪心算法
 * @see LeetCode152
 */
public class LeetCode53 {
    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(leetCode53.maxSubArray(nums));
    }

    // 动态规划状态转移方程：
    // f(i) = max( f(i-1) + a[i], a[i] )
    // 其中，a[i] 表示在 i 处的值，f(i) 表示在 i 处的 最大连续子数组的和
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        // 存 f(i-1)，滚动数组思想
        int pre = max;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
