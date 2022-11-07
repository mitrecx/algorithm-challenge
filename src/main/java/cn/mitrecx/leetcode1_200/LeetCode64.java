package cn.mitrecx.leetcode1_200;

/**
 * 64. Minimum Path Sum
 *
 * 动态规划入门题
 */
public class LeetCode64 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        LeetCode64 leetCode64 = new LeetCode64();
        System.out.println(leetCode64.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 滚动数组
        int[] f = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    f[j] = f[j] + grid[i][j];
                    continue;
                }
                if (i == 0) {
                    f[j] = f[j - 1] + grid[i][j];
                    continue;
                }
                f[j] = Math.min(f[j], f[j - 1]) + grid[i][j];
            }
        }
        return f[n - 1];
    }
}
