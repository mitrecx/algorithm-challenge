package cn.mitrecx;

public class CutRod {
    int bottomUpCutRod(int[] price, int n) {
        int[] r = new int[n + 1];
        for (int i = 0; i < Math.min(price.length, n + 1); i++) {
            r[i] = price[i];
        }

        for (int i = 1; i <= n; i++) {
            int profit = 0;
            for (int j = 1; j <= i; j++)
                profit = Math.max(profit, r[j] + r[i - j]);
            r[i] = profit;
        }
        return r[n];
    }

    public static void main(String[] args) {
        int[] p = {
                0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30
        };//定义一个数组存储对应钢条长度的售价
        CutRod cutRod = new CutRod();
        System.out.println(cutRod.bottomUpCutRod(p, 3));

    }
}
