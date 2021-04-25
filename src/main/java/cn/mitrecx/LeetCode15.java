package cn.mitrecx;

import java.util.*;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        for (int i = 2; i < nums.length; i++) {
            int expectResult = -nums[i];
            Map<Integer, Integer> valueCount = new HashMap<>();

            List<Integer> tuple = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int expect = expectResult - nums[j];
                if (valueCount.containsKey(expect)) {
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.add(expect);
                    if (!contains(result, tuple)) {
                        result.add(new ArrayList<>(tuple));
                    }
                    tuple.clear();
                }
                valueCount.put(nums[j], j);
            }
        }
        return result;
    }

    public boolean contains(List<List<Integer>> result, List<Integer> tuple) {
        return result.stream().anyMatch(r -> {
            r.sort((a, b) -> a > b ? -1 : 1);
            tuple.sort((a, b) -> a > b ? -1 : 1);
            if (r.get(0).equals(tuple.get(0)) && r.get(1).equals(tuple.get(1)) && r.get(2).equals(tuple.get(2))) {
                return true;
            }
            return false;
        });
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(leetCode15.threeSum(nums));
    }
}
