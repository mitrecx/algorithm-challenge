package cn.mitrecx;

/**
 * Title: 136. Single Number
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 位运算, 异或运算
 */
public class LeetCode136 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        LeetCode136 leetCode136 = new LeetCode136();
        System.out.println(leetCode136.singleNumber(nums));
    }

    // 异或运算(^): 相同为0, 相异为1.
    // a^a=0;
    // a^0=a;
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r = r ^ num;
        }
        return r;
    }
}
