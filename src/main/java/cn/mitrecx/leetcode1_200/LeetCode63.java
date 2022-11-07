package cn.mitrecx.leetcode1_200;

/**
 * 63. Unique Paths II
 * 动态规划入门题
 */
public class LeetCode63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        LeetCode63 leetCode63 = new LeetCode63();
        System.out.println(leetCode63.uniquePathsWithObstacles_2(obstacleGrid));
//        System.out.println(leetCode63.uniquePathsWithObstacles_2(obstacleGrid2));
    }

    /**
     * 和 {@link LeetCode62} 解法相同的思路
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] r = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 0) {
                for (int j = i; j < m; j++) {
                    r[j][0] = 0;
                }
                break;
            }
            r[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 0) {
                for (int j = i; j < n; j++) {
                    r[0][j] = 0;
                }
                break;
            }
            r[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (obstacleGrid[i - 1][j] == 0) {
                    r[i][j] = r[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    r[i][j] += r[i][j - 1];
                }
            }
        }
        return r[m - 1][n - 1];
    }

    // 滚动数组
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }

}
