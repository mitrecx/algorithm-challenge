package cn.mitrecx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};
        int[] nums3 = {-2, -1, -1, 1, 1, 2, 2};
//        System.out.println(leetCode18.fourSum(nums, 0));
//        System.out.println(leetCode18.fourSum(nums2, 8));
        System.out.println(leetCode18.fourSum(nums3, 0));
    }

    /**
     * 和 3Sum 解题思路一样, 只不过 4Sum 需要 fix 两个指针, 然后再用 left, right 双指针调整.
     * 而 3Sum 只要 fix 一个指针.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums.length < 4) {
            return r;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // 注意: 跳过相同的数
            while (i != 0 && nums[i] == nums[i - 1] && i < nums.length - 3) {
                i++;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 注意: 跳过相同的数
                while (j != i + 1 && nums[j] == nums[j - 1] && j < nums.length - 2) {
                    j++;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target) {
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        List<Integer> tr = new ArrayList<>();
                        tr.add(nums[i]);
                        tr.add(nums[j]);
                        tr.add(nums[left]);
                        tr.add(nums[right]);
                        r.add(tr);
                        // 注意: 跳过相同的数
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return r;
    }
}
