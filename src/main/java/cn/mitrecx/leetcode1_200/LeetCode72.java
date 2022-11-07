package cn.mitrecx.leetcode1_200;

/**
 * 72. Edit Distance
 * hard
 * <p>
 * 动态规划:
 * dp[i][j] 表示 word1 前i个字符 到 word2 前j个字符 的最小编辑距离,
 * 状态转移方程:
 * dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1] + 1或0)
 * <p>
 * dp[i-1][j] 表示 word1 前i-1个字符 到 word2 前j个字符 的最小编辑距离,
 * dp[i-1][j] + 1 相当于删除 word1 中一个字符, 计算出的 dp[i][j] 最小编辑距离.
 * dp[i][j-1] + 1 相当于在 word1 中增加一个字符(word2中的字符), 计算出的 dp[i][j] 最小编辑距离.
 * dp[i-1][j-1] + 1或0 相当于 word1 中替换1或0个字符, 计算出的 dp[i][j] 最小编辑距离.
 */
public class LeetCode72 {
    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
//        System.out.println(leetCode72.minDistance("horse", "ros"));
//        System.out.println(leetCode72.minDistance("intention", "execution"));
        System.out.println(leetCode72.minDistance("abc", "eabc"));
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                int del = dp[i - 1][j] + 1;
                int insert = dp[i][j - 1] + 1;
                int replace = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace = replace + 1;
                }
                dp[i][j] = Math.min(del, Math.min(insert, replace));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
