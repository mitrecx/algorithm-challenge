package cn.mitrecx;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 169. Majority Element
 * Difficulty: Easy
 * Self Difficulty:
 * kw: Boyer–Moore
 */
public class LeetCode169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        LeetCode169 leetCode169 = new LeetCode169();
        System.out.println(leetCode169.majorityElement_2b(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int n = nums.length / 2;
        if (n == 0) {
            return nums[0];
        }
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                if (counts.get(num) > n - 1) {
                    return num;
                }
                counts.put(num, counts.get(num) + 1);
            }
        }
        // should not happen
        return -1;
    }

    /**
     * Boyer-Moore 投票算法:
     * 把众数记为 +1，把其他数记为 −1，将它们全部加起来，和大于 0
     */
    public int majorityElement_2b(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                if (count == 0) {
                    majority = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return majority;
    }


    public int majorityElement_2bb(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
