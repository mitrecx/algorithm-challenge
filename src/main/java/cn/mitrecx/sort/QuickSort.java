package cn.mitrecx.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    Random random = new Random();

    private int partition(int[] a, int begin, int end) {
        // int pivot = begin + random.nextInt(end-begin+1);
        // swap(a, pivot, end);

        // 取 pivot 为 end
        int pv = a[end];
        // 假设 i 及以前的数值都是小于 a[pivot]
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (a[j] <= pv) {
                i++;
                swap(a, i, j);
            }
        }
        a[end] = a[i + 1];
        a[i + 1] = pv;
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void quickSort(int[] a, int begin, int end) {
        if (begin < end) {
            int pivot = partition(a, begin, end);
            quickSort(a, begin, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 5, 1, 2, 7, 11, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


}
