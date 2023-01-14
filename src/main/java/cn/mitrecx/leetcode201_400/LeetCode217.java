package cn.mitrecx.leetcode201_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a>
 */
public class LeetCode217 {
    public static void main(String[] args) {
        LeetCode217 leetCode217 = new LeetCode217();
        int[] nums = {1, 2, 3, 4};
        System.out.println(leetCode217.containsDuplicate(nums));
        int[] nums2 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(leetCode217.containsDuplicate(nums2));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (!s.add(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate_2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}

