package cn.mitrecx.sort;

import java.util.Arrays;

/**
 * 堆, 是完全二叉树结构.<p>
 * 大根堆: 每个结点值都大于等于 左右孩子结点值;<p>
 * 小根堆: 每个结点值都小于等于 左右结点值.<p>
 * 堆排序是一种选择排序, 是不稳定排序<p>
 */
public class HeapSort {
    public int[] sort(int[] a) {
        // 1. 构建堆
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjust(a, i, a.length);
        }

        for (int j = a.length - 1; j >= 0; j--) {
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            // 2. 重建堆
            adjust(a, 0, j);
        }

        return a;
    }

    /**
     * 调整堆:<p>
     * 1. 当没有堆结构时, 可以利用此方法构建堆.<p>
     * 2. 当堆的根结点被替换时, 可以利用此方法重建堆.
     *
     * @param a    在构建堆时, 这个数组可以看成一个完全二叉树; 在重建堆时, 这个数组是一个堆结构(除了根结点外)
     * @param curr 当前需要调整的结点
     * @param len  堆(数组)应用的长度
     */
    public void adjust(int[] a, int curr, int len) {
        int temp = a[curr];
        int left = curr * 2 + 1;
        for (int child = left; child < len; child = child * 2 + 1) {
            // 右子结点 大于 左子结点
            if (child + 1 < len && a[child + 1] > a[child]) {
                child++;
            }
            // 子节点大于父节点
            if (a[child] > temp) {
                a[curr] = a[child];
                curr = child;
            } else {
                break;
            }
        }
        a[curr] = temp;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 7, 11, 3};
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(heapSort.sort(a)));
    }

}
