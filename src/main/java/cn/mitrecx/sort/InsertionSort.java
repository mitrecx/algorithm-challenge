package cn.mitrecx.sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int temp = a[j];
            while (j - 1 >= 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.sort(a)));
    }
}
