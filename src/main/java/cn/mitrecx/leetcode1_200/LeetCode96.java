package cn.mitrecx.leetcode1_200;

/**
 * 96. Unique Binary Search Trees
 * Medium
 * 上_
 * dynamic programming(动态规划)
 * 状态转移方程推导:
 * G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数,
 * F(i,n): 以 i 为根, 序列长度为 n 的不同二叉搜索树个数 (1 ≤ i ≤ n)
 * G(n) = 求和[i=1->n]F(i,n).
 * 而 F(i,n) = G(i-1)*G(n-i),
 * 因此 G(n) = 求和[i=1->n]G(i-1)*G(n-i).
 */
public class LeetCode96 {
    public static void main(String[] args) {
        LeetCode96 lc = new LeetCode96();
        System.out.println(lc.numTrees(2));
        System.out.println(lc.numTrees(3));
        System.out.println(lc.numTrees(5));
    }

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            // G(n) = 求和[i=1->n]G(i-1)*G(n-i).
            for (int j = 1; j <= i; j++) {
                G[i] = G[i] + G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }

}
