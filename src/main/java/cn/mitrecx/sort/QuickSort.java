package cn.mitrecx.sort;

import java.util.Arrays;

public class QuickSort {
    private int partition(int[] a, int begin, int end) {
        int pivot = a[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[end] = a[i + 1];
        a[i + 1] = pivot;
        return i + 1;
    }

    public void quickSort(int[] a, int begin, int end) {
        if (begin < end) {
            int pivot = partition(a, begin, end);
            quickSort(a, begin, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
