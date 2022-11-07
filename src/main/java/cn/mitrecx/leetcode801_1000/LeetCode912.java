package cn.mitrecx.leetcode801_1000;

import java.util.Random;

/**
 * https://leetcode.com/problems/sort-an-array/
 */
public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] a, int begin, int end) {
        if (begin < end) {
            int pivot = partition(a, begin, end);
            quickSort(a, begin, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }

    Random random = new Random();

    private int partition(int[] a, int begin, int end) {
        int pivot = begin + random.nextInt(end - begin + 1);
        swap(a, pivot, end);

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

}
