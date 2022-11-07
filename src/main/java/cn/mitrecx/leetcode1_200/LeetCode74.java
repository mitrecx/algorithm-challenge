package cn.mitrecx.leetcode1_200;

/**
 * 74. Search a 2D Matrix
 * medium
 * <p>
 * 二分查找(binary search)
 */
public class LeetCode74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix3 = {{1}};
        LeetCode74 leetCode74 = new LeetCode74();
        System.out.println(leetCode74.searchMatrix(matrix, 3));
        System.out.println(leetCode74.searchMatrix(matrix2, 13));
        System.out.println(leetCode74.searchMatrix(matrix3, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int frontRow = 0;
        int backRow = matrix.length - 1;
        int tail = matrix[0].length - 1;
        while (frontRow < backRow) {
            int midRow = (frontRow + backRow) / 2;
            if (target == matrix[midRow][0]) {
                return true;
            }
            if (target > matrix[midRow][0]) {
                if (target > matrix[midRow][tail]) {
                    frontRow = midRow + 1;
                } else if (target < matrix[midRow][tail]) {
                    frontRow = midRow;
                    break;
                } else {
                    // 找到结果直接返回
                    return true;
                }
            } else {
                backRow = midRow - 1;
            }
        }

        return binarySearch(matrix[frontRow], target);
    }

    public boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == row[mid]) {
                return true;
            }
            if (target < row[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
