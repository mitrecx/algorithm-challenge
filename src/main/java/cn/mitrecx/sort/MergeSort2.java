package cn.mitrecx.sort;

import java.util.Arrays;

public class MergeSort2 {
    public void mergeSort(int[] a, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(a, begin, mid);
            mergeSort(a, mid + 1, end);
            merge(a, begin, mid, end);
        }
    }

    private void merge(int[] a, int begin, int mid, int end) {
        int[] left = new int[mid - begin + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = a[begin + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = a[mid + 1 + i];
        }

        int l = 0, r = 0;
        int i = begin;
        while (i <= end) {
            if (l >= left.length || r >= right.length) {
                break;
            }
            if (left[l] <= right[r]) {
                a[i++] = left[l++];
            } else {
                a[i++] = right[r++];
            }
        }

        if (l >= left.length) { // 左边序列元素读完, 直接把右边的序列依次放入a中
            while (r < right.length) {
                a[i++] = right[r++];
            }
        } else { // 右边序列元素读完, 直接把左边的序列依次放入a中
            while (l < left.length) {
                a[i++] = left[l++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        MergeSort2 mergeSort = new MergeSort2();
        mergeSort.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
