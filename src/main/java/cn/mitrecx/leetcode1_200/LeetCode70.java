package cn.mitrecx.leetcode1_200;

/**
 * 70. Climbing Stairs
 * <p>
 * 动态规划:
 * f(x) = f(x-1) + f(x-2)
 */
public class LeetCode70 {
    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        System.out.println(leetCode70.climbStairs(2));
        System.out.println(leetCode70.climbStairs(3));
        System.out.println(leetCode70.climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int firstToLast = 2, secondToLast = 1;
        for (int i = 3; i <= n; i++) {
            int temp = firstToLast;
            firstToLast += secondToLast;
            secondToLast = temp;
        }
        return firstToLast;
    }
}
