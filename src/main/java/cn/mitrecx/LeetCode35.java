package cn.mitrecx;

/**
 * 35. Search Insert Position
 */
public class LeetCode35 {
    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(leetCode35.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 循环结束, 如果不溢出的话, nums[l] 一定大于 target; nums[r] 一定小于 target; 所以取 l 即可.
        // 如果 l 溢出的话, 取 l 即可.
        return l;
    }
}
