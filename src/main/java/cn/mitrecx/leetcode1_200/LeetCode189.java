package cn.mitrecx.leetcode1_200;

import java.util.Arrays;

/**
 * Title: 189. Rotate Array
 * Difficulty: Medium
 * Self Difficulty:
 * kw:
 */
public class LeetCode189 {
    public static void main(String[] args) {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        leetCode189.rotate_3b(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

    /**
     * 翻转3次。
     * 这种解法只用到 O(1) 空间复杂度。
     */
    public void rotate_2b(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start > end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 最完美的解法（耗时上比2b更少），但有点复杂。
     * 需要用 辗转相除法 计算最大公约数。
     * 而且需要了解概念：
     * 两个自然数的 最大公约数(gcd) 与它们的 最小公倍数(lcm) 的乘积等于这两个数的乘积。
     * <p>
     * 解题思路：
     * 把数组看成首尾相连的环状数组，假设 p 从下标 0 处出发，依次替换 i1 = (0 + k ) % n，i2 = (i1 + k ) % n，...
     * 那么在绕过 x 圈以后，p 一定会回到 0 处。 假设这个过程总共遍历了 m 个元素，
     * 而这个过程中扫过的元素可以列出等式：x * n = m * k
     * 扫过的元素 x * n 一定是 (n, k) 的最小公倍数，记为 lcm(n, k)
     * 所以 单次遍历的元素个数为 m = lcm(n, k) / k
     * 所以，要遍历完所有元素，必须遍历的次数为：n / m = gcd(n, k)
     */
    public void rotate_3b(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int i = 0; i < count; i++) {
            int curr = i;
            int currVal = nums[i];
            do {
                int next = (curr + k) % n;
                int temp = nums[next];
                nums[next] = currVal;
                currVal = temp;
                curr = next;
            } while (curr != i);
        }
    }

    // 辗转相除计算最大公约数（Greatest Common Divisor）
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
