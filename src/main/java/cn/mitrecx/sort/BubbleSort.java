package cn.mitrecx.sort;

import java.util.Arrays;

/**
 * {@link CombSort} 是改进版的冒泡排序.
 */
public class BubbleSort {
    public int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(a)));
    }
}
