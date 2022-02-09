package cn.mitrecx;

/**
 * 26. Remove Duplicates from Sorted Array
 * @see LeetCode80
 */
public class LeetCode26 {
    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        int[] nums = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(leetCode26.removeDuplicates(nums));
        System.out.println(leetCode26.removeDuplicates(nums2));
    }

    public int removeDuplicates(int[] nums) {
        int j = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {
                int t = i;
                while (t < j) {
                    int temp = nums[t + 1];
                    nums[t + 1] = nums[t];
                    nums[t] = temp;
                    t++;
                }
                j--;
            }
        }
        return j + 1;
    }
}
