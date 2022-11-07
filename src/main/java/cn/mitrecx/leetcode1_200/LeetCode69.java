package cn.mitrecx.leetcode1_200;

/**
 * 69. Sqrt(x)
 * <p>
 * 二分查找
 */
public class LeetCode69 {
    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        System.out.println(leetCode69.mySqrt(4));
        System.out.println(leetCode69.mySqrt(10));
    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        int result = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if ((long) mid * mid <= x) { // 注意溢出 !!!
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
