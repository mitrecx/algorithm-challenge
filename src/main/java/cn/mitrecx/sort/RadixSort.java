package cn.mitrecx.sort;

import java.util.Arrays;

public class RadixSort {
    private int getMax(int[] a) {
        if (a == null || a.length == 0) {
            throw new RuntimeException("invalid array.");
        }
        int max = a[0];
        for (int j : a) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }

    private void countSort(int[] a, int exp) {
        int[] countArray = new int[10];
        Arrays.fill(countArray, 0);

        for (int j : a) {
            countArray[(j / exp) % 10]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] sorted = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            sorted[countArray[(a[i] / exp) % 10] - 1] = a[i];
            countArray[(a[i] / exp) % 10]--;
        }

        System.arraycopy(sorted, 0, a, 0, sorted.length);
    }

    public void sort(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort rs = new RadixSort();
        // Function Call
        rs.sort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
