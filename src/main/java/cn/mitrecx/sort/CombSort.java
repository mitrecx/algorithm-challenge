package cn.mitrecx.sort;

import java.util.Arrays;

/**
 * 梳排序(Comb sort)是一种由 Dobosiewicz 于1980年所发明的不稳定排序算法.<p>
 * 梳排序是改良了冒泡排序.<p>
 * 梳排序在进行冒泡排序之前, 可以保证序列头部是小数, 序列尾部是大数.<p>
 * @see BubbleSort
 */
public class CombSort {
    public static final float SHRINK_FACTOR = 1.3f;

    public int[] sort(int[] a) {
        int gap = a.length;

        while (gap > 0) {
            gap = (int) (gap / SHRINK_FACTOR);
            for (int i = 0; i < a.length - gap; i++) {
                if (a[i] > a[i + gap]) {
                    int temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        CombSort combSort = new CombSort();
        System.out.println(Arrays.toString(combSort.sort(a)));
    }
}
