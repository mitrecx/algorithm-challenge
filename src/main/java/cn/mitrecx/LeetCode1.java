package cn.mitrecx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (valueIndexMap.containsKey(expect)) {
                return new int[]{valueIndexMap.get(expect), i};
            }
            valueIndexMap.put(nums[i], i);
        }
        // this should never happen
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
