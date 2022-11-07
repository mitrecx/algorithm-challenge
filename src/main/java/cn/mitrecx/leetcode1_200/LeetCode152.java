package cn.mitrecx.leetcode1_200;

/**
 * Title: 152. Maximum Product Subarray
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: 动态规划
 *
 * @see LeetCode53
 */
public class LeetCode152 {
    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        LeetCode152 leetCode152 = new LeetCode152();
        System.out.println(leetCode152.maxProduct_2b(nums));
    }

    // 考虑到负负得正，这题需要考虑最大和最小乘积。
    // 考虑使用动态规划解决：
    // 状态转移方程：
    // f_max(i) =  max( f_max(i-1) * a[i], f_min(i-1) * a[i], a[i] )
    // f_min(i) =  min( f_max(i-1) * a[i], f_min(i-1) * a[i], a[i] )
    // 其中，a[i] 表示给定数组的第 i 位，f_max[i] 表示在 i 位的最大乘积，f_min 表示在 i 位的最小乘积。
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    // 上面使用了 O(n) 的空间复杂度，可以使用滚动数组思想优化成 O(1)
    public int maxProduct_2b(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int originMaxF = maxF;
            maxF = Math.max(maxF * nums[i], Math.max(nums[i], minF * nums[i]));
            minF = Math.min(minF * nums[i], Math.min(nums[i], originMaxF * nums[i]));
            max = Math.max(max, maxF);
        }
        return max;
    }
}
