package cn.mitrecx.leetcode1_200;

/**
 * 62. Unique Paths
 *
 * 动态规划:
 * f(i,j) 表示 从左上角走到 (i,j) 的路径数量, i ∈ [0,m), j ∈ [0, n).
 * 动态规划转移方程:
 * f(i,j) = f(i-1, j) + f(i, j-1)
 * 初始条件:
 * f(0,x) = 1, f(x, 0) = 1;
 */
public class LeetCode62 {
    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        System.out.println(leetCode62.uniquePaths(3, 2));
        System.out.println(leetCode62.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] r = new int[m][n];
        for (int i = 0; i < m; i++) {
            r[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            r[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                r[i][j] = r[i - 1][j] + r[i][j - 1];
            }
        }
        return r[m - 1][n - 1];
    }
}
