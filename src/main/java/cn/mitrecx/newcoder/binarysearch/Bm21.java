package cn.mitrecx.newcoder.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * BM21 旋转数组的最小数字
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 给定这样一个旋转数组，求数组中的最小值。
 */
public class Bm21 {
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        Bm21 bm21 = new Bm21();
        System.out.println(bm21.minNumberInRotateArray(a));
    }

    /**
     * 数组是部分有效的, 可以用 二分法 查找最小值.
     * 但要注意: 二分时, array[mid] == array[right] 的情况下, 是无法判断最小值在 左 还是 右.
     */
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[left] < array[right]) {
                return array[left];
            }
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else { // array[mid] == array[right] 时, 无法判断最小值在 左侧 还是 右侧
                left++;
            }
        }
        return array[left];
    }
}
