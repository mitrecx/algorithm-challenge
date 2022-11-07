package cn.mitrecx.leetcode1_200;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * medium
 * 绝妙双指针(two-pointers)
 * @see LeetCode26
 */
public class LeetCode80 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums3 = {-50, -50, -49, -48, -47, -47, -47, -46, -45, -43, -42, -41, -40, -40, -40, -40, -40, -40, -39, -38, -38, -38, -38, -37, -36, -35, -34, -34, -34, -33, -32, -31, -30, -28, -27, -26, -26, -26, -25, -25, -24, -24, -24, -22, -22, -21, -21, -21, -21, -21, -20, -19, -18, -18, -18, -17, -17, -17, -17, -17, -16, -16, -15, -14, -14, -14, -13, -13, -12, -12, -10, -10, -9, -8, -8, -7, -7, -6, -5, -4, -4, -4, -3, -1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 16, 17, 17, 18, 20, 21, 22, 22, 22, 23, 23, 25, 26, 28, 29, 29, 29, 30, 31, 31, 32, 33, 34, 34, 34, 36, 36, 37, 37, 38, 38, 38, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 47, 47, 48, 49, 49, 49, 50};
        LeetCode80 leetCode80 = new LeetCode80();
        System.out.println(leetCode80.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(leetCode80.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
        System.out.println(leetCode80.removeDuplicates(nums3));
    }

    // 效率很差!
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        // 有效子串下标范围 [m, n]
        int m = length - 1, n = m;
        for (int i = length - 1; i >= 0; ) {
            int cur = nums[i];
            int count = 1;
            int j = i - 1;
            while (j >= 0 && nums[j] == cur) {
                count++;
                j--;
            }
            if (count > 2) {
                int nextM = m - count;
                int nextN = n - count + 2;
                for (int t = nextM + 2; t <= nextN; t++) {
                    nums[t] = nums[t + count - 2];
                }
                m = nextM;
                n = nextN;
                i = j;
            } else if (count == 2) {
                m = m - 2;
                i = i - 2;
            } else {
                m--;
                i--;
            }
        }
        return n + 1;
    }

    // 超高效!
    public int removeDuplicates_2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        // 快指针表示已经检查过的数组的长度
        // 我们需要检查上上个应该被保留的元素 nums[slow - 2] 是否和当前待检查元素 nums[fast] 相同,
        // 相同 则 当前待检查元素 不应该被保留(直接 fast++)
        // [slow, fast) 区间表示无用的元素
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

}
