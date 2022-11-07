package cn.mitrecx.leetcode1_200;

import java.util.Arrays;

/**
 * Title: 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * Self Difficulty:
 * kw: two-pointers, binary-search
 */
public class LeetCode167 {
    public static void main(String[] args) {
        LeetCode167 leetCode167 = new LeetCode167();
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(leetCode167.twoSum(numbers, target)));
    }

    // binary-search
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2, t = 0;
                if (numbers[mid] == (t = target - numbers[i])) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > t) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        // should not happen
        return new int[]{0, 0};
    }

    // two-pointers
    // 初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
    // 如果两个元素之和等于目标值，则发现了唯一解。
    // 如果两个元素之和小于目标值，则将左侧指针右移一位。
    // 如果两个元素之和大于目标值，则将右侧指针左移一位。
    public int[] twoSum_2b(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        // should not happen
        return new int[]{0, 0};
    }
}
