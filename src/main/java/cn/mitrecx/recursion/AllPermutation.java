package cn.mitrecx.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class AllPermutation {
    public static void main(String[] args) {
        AllPermutation ap = new AllPermutation();
        String test1 = "abc";
        List<String> res = ap.permutation(test1);
        System.out.println(test1 + ": " + res);

        String test2 = "abca";
        List<String> res2 = ap.permutation(test2);
        System.out.println(test2 + ": " + res2);


        String test3 = "abca";
        List<String> res3 = new ArrayList<>();
        ap.processNoRepeat(test3.toCharArray(), 0, res3);
        System.out.println(test3 + ": " + res3);
    }

    public List<String> permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();
        process(chars, 0, ans);
        return ans;
    }

    /**
     * 全排列, 可重复
     * 思路: 先排第 0 个位置, 有 chars.length 种选择; 再排第 1 个位置, 有  chars.length - 1 种选择; 以此类推...
     *
     * @param chars 字符串序列
     * @param index 当前处理到的位置, 说明 [0, index -1] 已经排好了
     * @param ans   答案列表
     */
    private void process(char[] chars, int index, List<String> ans) {
        if (index >= chars.length) { // base case;
            ans.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            process(chars, index + 1, ans);
            swap(chars, i, index); // 恢复现场
        }
    }

    /**
     * 全排列, 不重复
     */
    private void processNoRepeat(char[] chars, int index, List<String> ans) {
        if (index >= chars.length) { // base case;
            ans.add(String.valueOf(chars));
            return;
        }
        boolean[] used = new boolean[26];
        for (int i = index; i < chars.length; i++) {
            if (!used[chars[i] - 'a']) { // 剪枝(分支限界)
                used[chars[i] - 'a'] = true;
                swap(chars, index, i);
                processNoRepeat(chars, index + 1, ans);
                swap(chars, index, i); // 恢复现场
            }
        }
    }


    private void swap(char[] chars, int index, int i) {
        char temp = chars[index];
        chars[index] = chars[i];
        chars[i] = temp;
    }


}
