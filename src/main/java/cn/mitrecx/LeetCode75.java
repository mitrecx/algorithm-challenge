package cn.mitrecx;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * medium
 * <p>
 * two pointers(双指针)
 */
public class LeetCode75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        LeetCode75 leetCode75 = new LeetCode75();
        leetCode75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sortColors(int[] nums) {
        // i 是遍历指针, i 之前的都是0, j 之后都是 1 或 2, k 后面的都是2
        int i = 0, j = nums.length - 1, k = j;
        while (i <= k) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[i] == 1) {
                while (i <= k && nums[k] == 1) {
                    k--;
                }
                if (i > k) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k--;
                continue;
            }
            if (nums[i] == 2) {
                while (i <= k && k <= j && nums[j] == 2) {
                    j--;
                    if (j < k) {
                        k = j;
                    }
                }
                if (i > k) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                if (j < k) {
                    k = j;
                }
            }
        }
    }


    // 优选
    public void sortColors_2(int[] nums) {
        // 同样是双指针, 写法上更简洁
        // p0 前面都是0, p2 后面都是2
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; ++i) {
            // 只要维护好 p0 和 p2 即可
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
