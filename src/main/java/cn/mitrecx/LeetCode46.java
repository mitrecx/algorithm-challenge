package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * 回溯算法 可以搜索得到所有的答案, 包括最优解.
 * 但是本质上它是一种遍历算法(对树的深度优先遍历), 时间复杂度比较高.
 */
public class LeetCode46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode46 leetCode46 = new LeetCode46();
        List<List<Integer>> lists = leetCode46.permute(nums);
        System.out.println(lists);
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    // 可以挨个取nums里的元素, 利用回溯, 构造一个不重不漏的树
    public List<List<Integer>> permute(int[] nums) {
        // 记录各个位置上的元素是否被使用
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, used);
        return result;
    }

    private void dfs(int[] nums, int depth, boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
