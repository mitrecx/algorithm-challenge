package cn.mitrecx.leetcode1_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * medium
 * 回溯 + 剪枝
 *
 * @see LeetCode78
 */
public class LeetCode90 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        LeetCode90 leetCode78 = new LeetCode90();
        List<List<Integer>> r = leetCode78.subsetsWithDup(nums);
        for (List<Integer> e : r) {
            System.out.println(e.toString());
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePrevious, int cur, int[] nums) {
        if (cur > nums.length - 1) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 不选当前位置
        dfs(false, cur + 1, nums);
        // 当前元素和上一个元素相同, 而且上一个元素没有被选中, 则当前元素也不选(直接返回)
        if (!choosePrevious && cur > 0 && nums[cur] == nums[cur - 1]) {
            return;
        }
        // 选当前位置
        temp.add(nums[cur]);
        dfs(true, cur + 1, nums);
        temp.remove(temp.size() - 1);
    }

}
