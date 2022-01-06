package cn.mitrecx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
//        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(leetCode15.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return results;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 相同的元素, 只要 fix(定) 一次就行了, 这样可以保证三元组不重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            int twoSum = 0 - nums[i];
            while (start < end) {
                int oneSum = twoSum - nums[start];
                if (oneSum == nums[end]) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[start]);
                    r.add(nums[end]);
                    results.add(r);
                    start++;
                    end--;
                    // 如果start和上一个元素相同, start后移, 保证三元组不重复
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                } else if (nums[end] > oneSum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return results;
    }
}
