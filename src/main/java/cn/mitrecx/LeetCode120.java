package cn.mitrecx;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 120. Triangle
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 三角形最小路径和, 经典动态规划(dynamic programming)
 */
public class LeetCode120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(ImmutableList.of(2));
        triangle.add(ImmutableList.of(3, 4));
        triangle.add(ImmutableList.of(6, 5, 7));
        triangle.add(ImmutableList.of(4, 1, 8, 3));
        LeetCode120 leetCode120 = new LeetCode120();
        System.out.println(leetCode120.minimumTotal(triangle));
    }

    /**
     * dp[i][j] 表示 第 i 层 的 第 j 个位置的路径和.
     * 状态转移方程:
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
     * 特别的, 边界去掉越界的情况, 转移方程:
     * 在开头: dp[i][0] = dp[i-1][0] + triangle[i][0];
     * 在末尾: dp[i][i] = dp[i-1][i-1] + triangle[i][i];
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[n - 1][0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
