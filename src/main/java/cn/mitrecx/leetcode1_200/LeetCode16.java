package cn.mitrecx.leetcode1_200;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */
public class LeetCode16 {
    public static void main(String[] args) {
        LeetCode16 leetCode16 = new LeetCode16();
//        int[] nums = {-1,2,1,-4}; int target = 1;
        int[] nums = {1, 1, -1, -1, 3};
        int target = -1;
        System.out.println(leetCode16.threeSumClosest(nums, target));
    }

    /**
     * 先排序, 然后遍历数组, 遍历过程中使用双指针.
     */
    public int threeSumClosest(int[] nums, int target) {
        int r = 1000;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            // 双指针
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(threeSum - target) < Math.abs(r - target)) {
                    r = threeSum;
                }
                // 3数之和大于 target, right 左移
                if (threeSum > target) {
                    right--;
                } else { // 3数之和小于等于 target, left 右移
                    left++;
                }
            }
        }
        return r;
    }
}
