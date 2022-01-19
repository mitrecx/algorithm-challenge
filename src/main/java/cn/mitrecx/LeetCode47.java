package cn.mitrecx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法 可以搜索得到所有的答案, 包括最优解.
 * 但是本质上它是一种遍历算法(对树的深度优先遍历), 时间复杂度比较高.
 */
public class LeetCode47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3};
        LeetCode47 leetCode47 = new LeetCode47();
        List<List<Integer>> lists = leetCode47.permuteUnique(nums);
        System.out.println(lists);
    }

    // 可以挨个取nums里的元素, 利用回溯, 构造一个不重不漏的树
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 记录各个位置上的元素是否被使用
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums,
                     int depth,
                     List<Integer> path,
                     boolean[] used,
                     List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 一定要自己画图理解
            // nums[i] == nums[i - 1] 说明前一个元素[i-1] 一定在之前的递归里用过了, 现在是属于回退选择新元素的阶段
            // used[i - 1] 为 false 说明不是第一次 在这里使用相同的元素
            // 不是第一次在这里使用相同的元素, 直接 continue
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
