package cn.mitrecx;

public class LeetCode27 {
    public static void main(String[] args) {
        LeetCode27 leetCode27 = new LeetCode27();
        int[] nums = {3, 2, 2, 3};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(leetCode27.removeElement(nums, 3));
        System.out.println(leetCode27.removeElement(nums2, 2));
    }

    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
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
