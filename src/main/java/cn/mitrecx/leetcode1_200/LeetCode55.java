package cn.mitrecx.leetcode1_200;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 *
 * @see LeetCode45
 */
public class LeetCode55 {
    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(leetCode55.canJump(nums));
        System.out.println(leetCode55.canJump(nums2));
    }

    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        int currentRoundEnd = 0;
        for (int i = 0; i < nums.length && i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == currentRoundEnd) {
                currentRoundEnd = maxIndex;
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
