package cn.mitrecx;

public class LeetCode53 {
    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(leetCode53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = max;
        // 贪心算法
        for (int i = 1; i < nums.length; i++) {
            // 当前和 取 Math.max(当前值, 之前和+当前值)
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(currSum, max);
        }
        return max;
    }
}
