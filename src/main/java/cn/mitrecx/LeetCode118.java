package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 118. Pascal's Triangle
 * Difficulty: Easy
 * Self Difficulty: 下
 * kw:
 */
public class LeetCode118 {
    public static void main(String[] args) {
        LeetCode118 leetCode118 = new LeetCode118();
        List<List<Integer>> r1 = leetCode118.generate(5);
        for (List<Integer> r : r1) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> element1 = new ArrayList<>();
        element1.add(1);
        ans.add(element1);
        if (numRows == 1) {
            return ans;
        }
        List<Integer> element2 = new ArrayList<>();
        element2.add(1);
        element2.add(1);
        ans.add(element2);
        if (numRows == 2) {
            return ans;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> element = new ArrayList<>();
            element.add(0, 1);
            for (int j = 1; j < i; j++) {
                List<Integer> up = ans.get(i - 1);
                element.add(up.get(j - 1) + up.get(j));
            }
            element.add(1);
            ans.add(element);
        }
        return ans;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/pascals-triangle/solution/yang-hui-san-jiao-by-leetcode-solution-lew9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> generate_2(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

}
