package cn.mitrecx.leetcode1_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * medium
 * <p>
 * 回溯
 *
 * @see LeetCode90
 */
public class LeetCode78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode78 leetCode78 = new LeetCode78();
        List<List<Integer>> r = leetCode78.subsets(nums);
        for (List<Integer> e : r) {
            System.out.println(e.toString());
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     * @see LeetCode77#dfs(int, int, int)
     */
    public void dfs(int cur, int[] nums) {
        if (cur > nums.length - 1) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 选择当前位置
        temp.add(nums[cur]);
        dfs(cur + 1, nums);
        temp.remove(temp.size() - 1);
        // 不选择当前位置
        dfs(cur + 1, nums);
    }
}
