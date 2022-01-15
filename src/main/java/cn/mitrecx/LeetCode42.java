package cn.mitrecx;

public class LeetCode42 {
    public static void main(String[] args) {
        LeetCode42 leetCode42 = new LeetCode42();
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(leetCode42.trap(height));
        System.out.println(leetCode42.trap2(height));
    }

    // 朴素的想法
    public int trap(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int curr = height[i];
            int maxLeft = 0, maxRight = 0;
            for (int l = 0; l < i; l++) {
                maxLeft = Math.max(maxLeft, height[l]);
            }
            for (int r = i + 1; r < height.length; r++) {
                maxRight = Math.max(maxRight, height[r]);
            }
            result = result + Math.max(0, Math.min(maxLeft, maxRight) - curr);
        }
        return result;
    }

    // 动态规划优化:
    // 从左往右记录最高的柱子, 依次记录到 maxLeft[]; 从右往左记录最高的柱子, 依次记录到 maxRight[];
    // 遍历 height 数组, i 处 蓄水面积为: max(maxLeft[i],maxRight[i]) - height[i]
    // (注意只有 height[i] 比两侧最高的柱子的较小者 还要矮, 才能蓄水.)
    public int trap2(int[] height) {
        int result = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            if (height[i] < maxLeft[i] && height[i] < maxRight[i]) {
                // 以低的bar为准
                result = result + Math.min(maxLeft[i], maxRight[i]) - height[i];
            }
        }
        return result;
    }
}
