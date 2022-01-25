package cn.mitrecx;

/**
 * 31. Next Permutation
 */
public class LeetCode31 {
    public static void main(String[] args) {
        LeetCode31 leetCode31 = new LeetCode31();
        int[] nums = {1, 2, 3};
        int[] nums2 = {1, 3, 2};
        leetCode31.nextPermutation(nums2);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }

    /**
     * 下一个排列:
     * [4,5,3,6,2,1] =>
     * [4,5,3,1,2,6]
     * <p>
     * 下一个排列元素组成的"数" 要比上一个 大
     */
    public void nextPermutation(int[] nums) {
        boolean max = true;
        for (int i = nums.length - 1; i > 0; i--) {
            // i-1 处出现了[小数]
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i - 1; j--) {
                    // i-1 和  刚好比[小数]大的元素 交换
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                // 不用排序, 翻转一下就会有序(本身就是逆序的),
                reverse(nums, i, nums.length - 1);

                max = false;
                break;
            }
        }
        if (max) {
            reverse(nums, 0, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
