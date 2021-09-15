package cn.mitrecx;

public class LeetCode96 {
    public int numTrees(int n) {
        int[] r = new int[n + 1];
        r[0] = r[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                r[i] = r[i] + r[j] * r[i - j - 1];
            }
        }
        return r[n];
    }

    public static void main(String[] args) {
        LeetCode96 lc = new LeetCode96();
        System.out.println(lc.numTrees(5));
    }
}
