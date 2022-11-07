package cn.mitrecx.leetcode1_200;

/**
 * 44. Wildcard Matching
 *
 * 动态规划(dynamic programing)
 * <p>
 * 参考:
 * https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode-solution/
 */
public class LeetCode44 {
    public static void main(String[] args) {
        LeetCode44 leetCode44 = new LeetCode44();
//        System.out.println(leetCode44.isMatch("aa", "a"));
        System.out.println(leetCode44.isMatch("aabcdefcdef", "*cd?*ef"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // 用 dp[i][j] 表示 字符串s 的前 i 个字符和 模式p 的前 j 个字符是否能匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 确定边界条件
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // 当s为空时, p以星号开头都是true(都能匹配上);
                // 例如 s="", p="**a", 那么 dp[0][1]=true, dp[0][2]=true, dp[0][3]=false
                dp[0][j] = true;
            } else {
                break;
            }
        }

        // 状态转移方程(这里 i, j 表示在s/p里的位置, 不是下标):
        // dp[i][j] = dp[i-1][j-1]; s(i)与p(j)相同 或 p(j)是问号
        // dp[i][j] = dp[i-1][j] || dp[i][j-1]; p(j)是星号, 分 使用星号 || 不使用星号 两种情况
        // dp[i][j] = false; 其他情况

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // dp[i - 1][j] 表示使用 j 位置上的星号;
                    // dp[i][j - 1] 表示不使用 j 位置上的星号
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
