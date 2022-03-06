package cn.mitrecx;

/**
 * Title: 122. Best Time to Buy and Sell Stock II
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 贪心算法
 */
public class LeetCode122 {
    public static void main(String[] args) {
        LeetCode122 leetCode122 = new LeetCode122();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(leetCode122.maxProfit(prices));
        System.out.println(leetCode122.maxProfit_2(prices));
    }

    // 贪心算法:
    // 把每天的的差值为正的加起来
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }


    /**
     * 动态规划, 这种思路很难想到. 但是很妙.
     *
     * 定义状态:
     * dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润;
     * dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润(i 从 0 开始).
     * 状态转移方程:
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxProfit_2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
