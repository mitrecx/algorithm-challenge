package cn.mitrecx.sort;

import java.util.Arrays;

/**
 * 该算法采用分治策略(divide-and-conquer).<p>
 * 分治法:<p>
 * 1. 分解(Divide): 将n个元素分成个含n/2个元素的子序列.<p>
 * 2. 解决(Conquer): 用合并排序法对两个子序列递归的排序.<p>
 * 3. 合并(Combine): 合并两个已排序的子序列已得到排序结果.<p>
 */
public class MergeSort {
    public void sort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    /**
     * @param a     排序数组
     * @param left  左指针, 确定解决(conquer)区间
     * @param right 右指针, 确定解决(conquer)区间
     * @param temp  额外空间, 存储解决(conquer)结果
     */
    public void sort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            // left < right, mid <= left
            int mid = (left + right) / 2;
            sort(a, left, mid, temp);
            sort(a, mid + 1, right, temp);
            merge(a, left, mid, right, temp);
        }
    }

    public void merge(int[] a, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= right) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (left <= right) {
            a[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
