package cn.mitrecx;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 0) {
            return 0;
        }
        int[] merge = new int[length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            }
            while (i < nums1.length && j < nums2.length && nums1[i] >= nums2[j]) {
                merge[k++] = nums2[j++];
            }
            if (i >= nums1.length && j < nums2.length) {
                merge[k++] = nums2[j++];
            }
            if (i < nums1.length && j >= nums2.length) {
                merge[k++] = nums1[i++];
            }
        }
        if (length == 1) {
            return merge[0];
        }
        int midIndex = length / 2;
        if (length % 2 == 0) {
            return (merge[midIndex] + merge[midIndex - 1]) / 2.0;
        } else {
            return merge[midIndex];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        LeetCode4 leetCode4 = new LeetCode4();
        System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));
    }
}
