package cn.mitrecx.newcoder.binarysearch;

import java.util.Arrays;

/**
 * BM20 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对 1000000007 取模的结果输出。
 */
public class Bm20 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        Bm20 bm20 = new Bm20();
        bm20.countAndSort(array, 0, array.length - 1);
        System.out.println(count);
    }

    static long count = 0;

    /**
     * 利用 二分法 把数组拆成左右两部分, 继续对着两部分利用二分法, 一直到最小单位.
     * 然后把两部分 合并并排序, 同时统计两部分中的 逆序对 的个数; 一直合并到完成整个数组.
     */
    private int[] countAndSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[] {array[left]};
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int[] la = countAndSort(array, left, mid);
        int[] ra = countAndSort(array, mid + 1, right);
        return mergeAndCount(la, ra);

    }

    private int[] mergeAndCount(int[] la, int[] ra) {
        if (la == null) {
            return ra;
        }
        if (ra == null) {
            return la;
        }
        int[] c = new int[la.length + ra.length];
        int i = la.length - 1, j = ra.length - 1, k = c.length - 1;

        while (i >= 0 && j >= 0) {
            if (la[i] > ra[j]) {
                count = count + j + 1;
                c[k--] = la[i--];
            } else {
                c[k--] = ra[j--];
            }
        }
        while (i >= 0) {
            c[k--] = la[i--];
        }
        while (j >= 0) {
            c[k--] = ra[j--];
        }
        return c;
    }
}
