package cn.mitrecx;

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * @see LeetCode54
 */
public class LeetCode59 {
    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int[][] r = leetCode59.generateMatrix(3);
        for (int[] e : r) {
            for (int i : e) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        // 定义4个边界: 左-右-上-下
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            // top 行
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num++;
            }
            // right 列
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            // 注意: 当 top = bottom 且 left < right 时,
            // 是不需要添加元素到 r 中的, 因为已经在前面2个for里添加了.
            // 如果没有这个if, 会出现重复添加问题.
            if (left < right && top < bottom) {
                // bottom 行
                for (int column = right - 1; column >= left; column--) {
                    matrix[bottom][column] = num++;
                }
                // left 列
                for (int row = bottom - 1; row >= top + 1; row--) {
                    matrix[row][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
