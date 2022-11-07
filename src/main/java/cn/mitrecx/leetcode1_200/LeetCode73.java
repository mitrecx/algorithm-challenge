package cn.mitrecx.leetcode1_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 73. Set Matrix Zeroes
 * medium
 */
public class LeetCode73 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        for (int[] z : matrix) {
            System.out.println(Arrays.toString(z));
        }

        LeetCode73 leetCode73 = new LeetCode73();
        leetCode73.setZeroes(matrix);
        System.out.println("----");
        for (int[] z : matrix) {
            System.out.println(Arrays.toString(z));
        }
    }

    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zeros = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> z = new ArrayList<>(2);
                    z.add(i);
                    z.add(j);
                    zeros.add(z);
                }
            }
        }
        for (List<Integer> z : zeros) {
            int row = z.get(0);
            int column = z.get(1);
            for (int i = 0; i < m; i++) {
                matrix[i][column] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
    }

    // 空间复杂度为O(1) 的 解法:
    // 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间
    //
    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void setZeroes_2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 行为0 或 列为0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
