package cn.mitrecx;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class LeetCode4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        LeetCode4 leetCode4 = new LeetCode4();
        System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));
    }

    int findKth2(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth2(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth2(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k1 = (nums1.length + nums2.length + 1) / 2;
        int k2 = (nums1.length + nums2.length + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, k1) + findKth(nums1, 0, nums2, 0, k2)) / 2.0;
    }

    public double findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int midIndex1 = index1 + k / 2 - 1;
        int v1 = midIndex1 < nums1.length ? nums1[midIndex1] : Integer.MAX_VALUE;

        int midIndex2 = index2 + k / 2 - 1;
        int v2 = midIndex2 < nums2.length ? nums2[midIndex2] : Integer.MAX_VALUE;

        if (v1 < v2) {
            return findKth(nums1, midIndex1 + 1, nums2, index2, k - k / 2);
        } else {
            return findKth(nums1, index1, nums2, midIndex2 + 1, k - k / 2);
        }
    }
}
