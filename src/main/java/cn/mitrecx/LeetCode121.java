package cn.mitrecx;

/**
 * Title: 121. Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Self Difficulty: 中
 * kw:
 */
public class LeetCode121 {
    public static void main(String[] args) {
        LeetCode121 leetCode121 = new LeetCode121();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(leetCode121.maxProfit(prices));
        int[] prices2 = {7, 1, 5, 3, 6, 4};
        System.out.println(leetCode121.maxProfit(prices2));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int currProfit = prices[i] - minPrice;
            if (currProfit > profit) {
                profit = currProfit;
            }
        }
        return profit;
    }

}
