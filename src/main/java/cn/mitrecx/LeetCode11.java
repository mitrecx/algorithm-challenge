package cn.mitrecx;

/**
 * 11. Container With Most Water
 */
public class LeetCode11 {
    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(leetCode11.maxArea(height));
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int volume = 0;
        while (l < r) {
            volume = Math.max(volume, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return volume;
    }
}
