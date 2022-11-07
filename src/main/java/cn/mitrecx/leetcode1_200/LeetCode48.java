package cn.mitrecx.leetcode1_200;

/**
 * 48. Rotate Image
 */
public class LeetCode48 {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int n = matrix.length;
        LeetCode48 leetCode48 = new LeetCode48();
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
        leetCode48.rotate(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        // i 层
        for (int i = 0; i < n / 2; i++) {
            // j 循环完成 i 层 四边元素的交换; 每次循环完成 4 个元素的交换, 下标自己画图可以推出来
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
