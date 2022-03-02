package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 119. Pascal's Triangle II
 * Difficulty: Easy
 * Self Difficulty: 中
 * kw: 杨辉三角, 滚动数组
 */
public class LeetCode119 {
    public static void main(String[] args) {
        LeetCode119 leetCode119 = new LeetCode119();
        List<Integer> r = leetCode119.getRow(3);
        System.out.println(r.toString());
    }

    /**
     * 参考 {@link LeetCode118#generate_2b(int)}, 可以使用滚动数组优化空间复杂度到 O(rowIndex)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = curr;
        }
        return pre;
    }
}
