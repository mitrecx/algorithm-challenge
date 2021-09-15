package cn.mitrecx.algorithms.intro;

public class CutRod {
    int bottomUpCutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < Math.min(price.length + 1, n + 1); i++) {
            dp[i] = price[i - 1];
        }
        // 规模为i的子问题
        for (int i = 1; i <= n; i++) {
            int m = 0;
            for (int j = 1; j <= i; j++) {
                m = Math.max(m, dp[j] + dp[i - j]);
            }
            dp[i] = m;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //定义一个数组存储对应钢条长度的售价
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        CutRod cutRod = new CutRod();
        System.out.println(cutRod.bottomUpCutRod(p, 14));
    }
}
