package cn.mitrecx.leetcode1_200;

/**
 * 88. Merge Sorted Array
 * easy
 */
public class LeetCode88 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] r = new int[m + n];
        int curr = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                r[curr++] = nums1[i++];
            } else {
                r[curr++] = nums2[j++];
            }
        }
        while (i < m) {
            r[curr++] = nums1[i++];
        }
        while (j < n) {
            r[curr++] = nums2[j++];
        }
        if (m + n >= 0)
            System.arraycopy(r, 0, nums1, 0, m + n);
    }

    /**
     * 逆向双指针
     * 空间复杂度O(1)
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

}
