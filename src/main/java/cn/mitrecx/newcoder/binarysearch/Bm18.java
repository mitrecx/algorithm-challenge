package cn.mitrecx.newcoder.binarysearch;

/**
 * BM18 二维数组中的查找
 * 在一个二维数组array中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 要求:
 * 空间复杂度 O(1)，时间复杂度 O(n+m)
 */
public class Bm18 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 8, 9};
        int[] array2 = {2, 4, 9, 12};
        int[] array3 = {4, 7, 10, 13};
        int[] array4 = {6, 8, 11, 15};
        int[][] array = {array1, array2, array3, array4};
        Bm18 bm18 = new Bm18();
        System.out.println(bm18.find(7, array));

        int[] array5 = {1, 1};
        int[][] t = {array5};
        System.out.println(bm18.find(2, t));
    }

    /**
     * 从右上角(0, n)开始查,
     * 如果右上角值 value(0, n) < target, 说明此行都是小于 target 的, 下移一行, 把右上角变成(1, n);
     * 如果右上角值 value(0, n) > target, 说明此列都是大于 target 的, 左移一列, 把右上角变成(0, n - 1);
     * 如果右上角值 value(0, n) == target, 找到.
     */
    public boolean find(int target, int[][] array) {
        if (array[0] == null || array[0].length == 0) {
            return false;
        }

        int m = 0, n = array[0].length - 1;
        while (m < array.length && n >= 0) {
            if (array[m][n] > target) {
                n--;
            } else if (array[m][n] < target) {
                m++;
            } else {
                return true;
            }
        }
        return false;
    }
}
