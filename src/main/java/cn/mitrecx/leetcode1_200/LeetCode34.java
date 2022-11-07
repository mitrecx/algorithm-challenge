package cn.mitrecx.leetcode1_200;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1;
        int r1 = -1, r2 = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                r1 = findFirst(nums, start, end, target);
                r2 = findEnd(nums, start, end, target);
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[]{r1, r2};
    }

    private int findFirst(int[] nums, int start, int end, int target) {
        int s = start, e = end;
        while (s != e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                if (mid - 1 < start || nums[mid - 1] < target) {
                    return mid;
                } else {
                    e = mid - 1;
                }
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private int findEnd(int[] nums, int start, int end, int target) {
        int s = start, e = end;
        while (s != e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                if (mid + 1 > end || nums[mid + 1] > target) {
                    return mid;
                } else {
                    s = mid + 1;
                }
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCode34 lc = new LeetCode34();
        int[] nums = {1};
        int[] r = lc.searchRange(nums, 1);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }
}
