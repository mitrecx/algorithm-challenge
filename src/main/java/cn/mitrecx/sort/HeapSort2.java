package cn.mitrecx.sort;

import java.util.Arrays;

public class HeapSort2 {
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * (i + 1);
    }

    /**
     * 从下标 i 处 开始最大堆化
     * @param a
     * @param i
     * @param heapSize
     */
    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largestIndex  = i;
        if (l < heapSize && a[l] > a[i]) {
            largestIndex = l;
        }

        if (r < heapSize && a[r] > a[largestIndex]) {
            largestIndex = r;
        }
        if (largestIndex != i) {
            int temp = a[i];
            a[i] = a[largestIndex];
            a[largestIndex] = temp;

            maxHeapify(a, largestIndex, heapSize);
        }
    }

    public void buildMaxHeap(int[] a) {
        // i 从第一个非叶子结点开始构造
        for (int i = (a.length / 2 - 1); i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }

    public void heapSort(int[] a) {
        buildMaxHeap(a);
        int heapSize = a.length;
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;

            heapSize = heapSize - 1;
            maxHeapify(a, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        HeapSort2 heapSort = new HeapSort2();
        heapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
