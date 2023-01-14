package cn.mitrecx.recursion;

/**
 * 从左往右的尝试模型1
 * 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少?
 */
public class LeftToRight1 {
    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{10, 2, 3};
        LeftToRight1 left = new LeftToRight1();
        System.out.println(left.process(w, v, 0, 0, 5));

        int[] w2 = new int[]{3, 2, 4, 7};
        int[] v2 = new int[]{5, 6, 3, 19};
        int bag = 11;
        System.out.println(left.process(w2, v2, 0, 0, bag));
        System.out.println(left.processRest(w2, v2, 0, bag));
        System.out.println(left.processRestDp(w2, v2, bag));
    }

    /**
     * @param w        重量数组
     * @param v        价值数组
     * @param index    当前处理位置
     * @param alreadyW 当前处理位置之前的 [0, index-1] 处理得到的重量
     * @param bag      背包的容量
     * @return 当前位置及以后位置 所产生的价值, 返回 -1 表示非法结果
     */
    public int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        // bag 里已经装的重量超过了 bag 的容量
        if (alreadyW > bag) { // base case 1: 重量超了
            return -1;
        }
        if (index >= v.length) { // base case 2: 走到底了
            return 0;
        }
        // 不拿 index 位置的值
        int r1 = process(w, v, index + 1, alreadyW, bag);
        // 拿, 注意: 拿的情况 process 的处理结果是 index 后面的总和, 并没有包含 index 的值, 所以这里变量名用 r2Next 而不是 r2
        int r2Next = process(w, v, index + 1, alreadyW + w[index], bag);

        // r2 表示 index 位置以及 index 位置以后的 总重量
        int r2 = 0;
        if (r2Next != -1) {
            r2 = r2Next + v[index];
        }

        return Math.max(r1, r2);
    }

    // 换一种思路
    private int processRest(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index >= w.length) {
            return 0;
        }
        int r1 = processRest(w, v, index + 1, rest);

        int r2 = 0;
        if (rest >= w[index]) {
            r2 = v[index] + processRest(w, v, index + 1, rest - w[index]);
        }
        return Math.max(r1, r2);
    }

    // 动态规划: 去除重复计算
    // 把 f(index, rest) 抽出来, 搞成一个二维表
    private int processRestDp(int[] w, int[] v, int bag) {
        // 当前位置:剩余重量
        // dp[0][20] 表示 0 号位置, 剩余 20 重量
        int[][] dp = new int[w.length + 1][bag + 1];
        // dp[w.length][...] = 0
        for (int index = w.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                // dp[index][rest] = ?;
                int r1 = dp[index + 1][rest];
                int r2 = 0;
                if (rest >= w[index]) {
                    r2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(r1, r2);

            }
        }
        return dp[0][bag];
    }
}
