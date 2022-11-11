package cn.mitrecx.newcoder.binarysearch;

/**
 * BM19 寻找峰值
 * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
 * 1.峰值元素是指其值严格大于左右相邻值的元素。
 * 2.假设 nums[-1] = nums[n] = −∞
 * 3.对于所有 i 都有 nums[i] != nums[i + 1]
 * 要求:
 * 使用O(logN)的时间复杂度解决问题.
 * 示例:
 * 输入[2, 4, 1, 2, 7, 8, 4]时，会形成两个山峰，
 * 一个是索引为 1，峰值为 4 的山峰，
 * 另一个是索引为 5，峰值为 8 的山峰.
 */
public class Bm19 {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 2, 7, 8, 4};
        Bm19 bm19 = new Bm19();
        System.out.println(bm19.findPeakElement(array));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (left == right) {
                return left;
            }
            int mid = (right - left) / 2 + left;
            // 看 mid 左右相邻的两个元素; 右侧高说明右侧一定有高峰, 否则说明左侧一定有高峰
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
