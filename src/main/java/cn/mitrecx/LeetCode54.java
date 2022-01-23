package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * <p>
 * We go boundary by boundary and move inwards.
 * That is the essential operation.
 * First row, last column, last row, first column and then we move inwards by 1 and then repeat.
 * That's all, that is all the simulation that we need.
 */
public class LeetCode54 {
    public static void main(String[] args) {
        LeetCode54 leetCode54 = new LeetCode54();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(leetCode54.spiralOrder(matrix2));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new ArrayList<>();
        // 定义4个边界: 左-右-上-下
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // top 行
            for (int column = left; column <= right; column++) {
                r.add(matrix[top][column]);
            }
            // right 列
            for (int row = top + 1; row <= bottom; row++) {
                r.add(matrix[row][right]);
            }
            // 注意: 当 top = bottom 且 left < right 时,
            // 是不需要添加元素到 r 中的, 因为已经在前面2个for里添加了.
            // 如果没有这个if, 会出现重复添加问题.
            if (left < right && top < bottom) {
                // bottom 行
                for (int column = right - 1; column >= left; column--) {
                    r.add(matrix[bottom][column]);
                }
                // left 列
                for (int row = bottom - 1; row >= top + 1; row--) {
                    r.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return r;
    }
}
