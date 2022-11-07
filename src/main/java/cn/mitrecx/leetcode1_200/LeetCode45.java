package cn.mitrecx.leetcode1_200;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 *
 * @see LeetCode55
 */
public class LeetCode45 {
    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(leetCode45.jump(nums));
    }

    public int jump(int[] nums) {
        int maxPosition = 0;
        // 当前轮的最后一个元素下标
        int currentRoundEnd = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == currentRoundEnd) {
                steps++;
                currentRoundEnd = maxPosition;
            }
        }
        return steps;
    }
}
