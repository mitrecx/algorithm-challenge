package cn.mitrecx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title: 128. Longest Consecutive Sequence
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: hash 表
 * 这题要求时间复杂度为 O(n), 此时应该想到 hash.
 */
public class LeetCode128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        LeetCode128 leetCode128 = new LeetCode128();
        System.out.println(leetCode128.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        // Set<Integer> numSet = Arrays.stream(nums).collect(Collectors.toSet());
        Set<Integer> numSet = new HashSet<>();
        Arrays.stream(nums).forEach(numSet::add);

        // Longest Consecutive Sequence
        int lcs = 0;
        for (int num : numSet) {
            // num 不是连续序列的第一个, 直接跳过. 我们只处理 连续序列的第一个数字.
            if (numSet.contains(num - 1)) {
                continue;
            }
            // num 是连续序列的第一个
            int currNum = num;
            int currLcs = 1;
            while (numSet.contains(currNum + 1)) {
                currNum++;
                currLcs++;
            }
            lcs = Math.max(lcs, currLcs);
        }
        return lcs;
    }
}
