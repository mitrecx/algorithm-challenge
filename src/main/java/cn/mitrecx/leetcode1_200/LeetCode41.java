package cn.mitrecx.leetcode1_200;

/**
 * 41. First Missing Positive
 * hard
 *
 * 将数组视为 hash 表, 原地哈希.
 * hash 规则: 把 1 放在下标为 0 的位置, 把 2 放在下标为 1 的位置, ...
 */
public class LeetCode41 {
    public static void main(String[] args) {
        LeetCode41 leetCode41 = new LeetCode41();
        int[] nums = {7, 8, 9, 11, 12};
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(leetCode41.firstMissingPositive(nums));
        System.out.println(leetCode41.firstMissingPositive(nums2));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            while (nums[i] > 0 && nums[i] < nums.length + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
