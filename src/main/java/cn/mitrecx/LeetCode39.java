package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * 定义递归函数 dfs(target, combine, idx) 表示当前 在 candidates 数组 的第 idx 位,
 * 还剩 target 要组合, 已经组合的列表为 combine.
 * <p>
 * 递归的终止条件为 target <= 0 或者 candidates 数组被全部用完.
 * <p>
 * 那么在当前的函数中,
 * 每次我们可以选择跳过不用第 idx 个数, 即执行 dfs(target, combine, idx + 1).
 * <p>
 * 也可以选择使用第 idx 个数, 即执行 dfs(target - candidates[idx], combine, idx),
 * 注意到每个数字可以被无限制重复选取, 因此搜索的下标仍为 idx.
 */
public class LeetCode39 {
    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> r = leetCode39.combinationSum(candidates, target);
        for (List<Integer> e : r) {
            System.out.println(e);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(result, combine, candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result,
                     List<Integer> combine,
                     int[] candidates,
                     int index,
                     int target) {
        if (index >= candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }

        // 跳过当前元素
        dfs(result, combine, candidates, index + 1, target);
        // 选择当前元素
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            // 注意: 用 target - candidates[index]
            dfs(result, combine, candidates, index, target - candidates[index]);
            combine.remove(combine.size() - 1);
        }

    }
}
