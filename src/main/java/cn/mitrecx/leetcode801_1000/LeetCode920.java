package cn.mitrecx.leetcode801_1000;

/**
 * hard
 * <p>
 * 动态规划
 * <p>
 * https://leetcode.com/problems/number-of-music-playlists/
 */
public class LeetCode920 {
    public static void main(String[] args) {
        LeetCode920 leetCode920 = new LeetCode920();
        System.out.println(leetCode920.numMusicPlaylists(3, 3, 1));
        System.out.println(leetCode920.numMusicPlaylists(2, 3, 0));
        System.out.println(leetCode920.numMusicPlaylists(2, 3, 1));
    }

    /**
     * dp[i][j] 表示总共放了i首歌, 其中j首是不同的
     * 状态转移方程:
     * dp[i][j] = dp[i-1][j-1]*(n-(j-1)) + dp[i-1][j]*(j-k)    (j > k)
     * dp[i][j] = dp[i-1][j-1]*(n-(j-1))   (j <= k)
     */
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
                    System.out.println(dp[i][j]);
                }
            }
        }
        return (int) dp[goal][n];
    }
}
