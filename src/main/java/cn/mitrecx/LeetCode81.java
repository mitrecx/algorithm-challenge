package cn.mitrecx;

/**
 * 81. Search in Rotated Sorted Array II
 * Medium
 * 二分查找
 * 注意: 本题和 33 题不同, 因为本题数组里的元素可以重复
 *
 * @see LeetCode33
 */
public class LeetCode81 {
    public static void main(String[] args) {
        LeetCode81 leetCode81 = new LeetCode81();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(leetCode81.search(nums, 0));
        System.out.println(leetCode81.search(nums, 3));
        // 注意这种情况
        int[] nums2 = {1, 2, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(leetCode81.search(nums2, 2));
    }

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // N.B., before being rotated, nums sorted non-decreasing order (not necessarily with distinct values)
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            if (nums[left] <= nums[mid]) {
                int r = binarySearch(nums, left, mid, target);
                if (r != -1) {
                    return true;
                }
                left = mid + 1;
            } else {
                int r = binarySearch(nums, mid, right, target);
                if (r != -1) {
                    return true;
                }
                right = mid - 1;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
