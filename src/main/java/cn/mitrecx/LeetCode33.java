package cn.mitrecx;

/**
 * 33. Search in Rotated Sorted Array
 */
public class LeetCode33 {
    public static void main(String[] args) {
        LeetCode33 leetCode33 = new LeetCode33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(leetCode33.search(nums, 0));
        System.out.println(leetCode33.search(nums2, 3));
    }

    // 将数组一分为二, 其中一定有一个是有序的, 另一个可能是有序, 也能是部分有序.
    // 此时有序部分用二分法查找.
    // 无序部分再一分为二, 其中一个一定有序, 另一个可能有序, 可能无序. 就这样循环.
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            int res = -1;
            if (nums[mid] > nums[l]) {
                if ((res = binarySearch(nums, l, mid, target)) != -1) {
                    return res;
                }
            }
            if (nums[mid] < nums[r]) {
                if ((res = binarySearch(nums, mid, r, target)) != -1) {
                    return res;
                }
            }
            if (nums[mid] < nums[l]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
