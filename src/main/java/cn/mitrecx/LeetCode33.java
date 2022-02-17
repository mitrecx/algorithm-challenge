package cn.mitrecx;

/**
 * 33. Search in Rotated Sorted Array
 * Medium
 * 二分查找
 *
 * @see LeetCode81
 */
public class LeetCode33 {
    public static void main(String[] args) {
        LeetCode33 leetCode33 = new LeetCode33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(leetCode33.search(nums, 0));
        System.out.println(leetCode33.search(nums, 3));
    }

    // 将数组一分为二, 其中一定有一个是有序的, 另一个可能是有序, 也能是部分有序.
    // 此时有序部分用二分法查找.
    // 无序部分再一分为二, 其中一个一定有序, 另一个可能有序, 可能无序. 就这样循环.
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid]) {
                int r = binarySearch(nums, left, mid, target);
                if (r != -1) {
                    return r;
                }
                left = mid + 1;
            } else {
                int r = binarySearch(nums, mid, right, target);
                if (r != -1) {
                    return r;
                }
                right = mid - 1;
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
