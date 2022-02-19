package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * medium
 * <p>
 * 回溯+剪枝
 */
public class LeetCode77 {

    public static void main(String[] args) {
        LeetCode77 leetCode77 = new LeetCode77();
        leetCode77.combine(4, 2);
        for (List<Integer> r : leetCode77.ans) {
            System.out.println(r.toString());
        }
    }

    List<Integer> temp = new ArrayList<Integer>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    /**
     * @see LeetCode39#dfs(int[], int, int)
     */
    public void dfs(int cur, int n, int k) {
        // 剪枝: temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
