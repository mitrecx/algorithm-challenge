package cn.mitrecx.leetcode1_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Title: 131. Palindrome Partitioning
 * Difficulty: Medium
 * Self Difficulty: 影
 * kw: 动态规划, 回溯
 */
public class LeetCode131 {


    public static void main(String[] args) {
        LeetCode131 leetCode131 = new LeetCode131();
        List<List<String>> r = leetCode131.partition("aab");
        for (List<String> e : r) {
            System.out.println(e.toString());
        }
    }

    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    boolean f[][];

    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new boolean[n][n];
        IntStream.range(0, n).forEach(i -> Arrays.fill(f[i], true));
        // 记录所有子串是否是 回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(0, s);
        return ans;
    }

    private void dfs(int i, String s) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (f[i][j]) { // s[i,j] 是回文
                temp.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
