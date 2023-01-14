package cn.mitrecx.recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列.
 * 注意子串和子序列概念的区分:
 * abc 的 全部子串(substring): a, ab, abc, b, bc, c
 * abc 的 全部子序列(subsequence): a, ab, ac, abc, b, bc, c
 */
public class Subsequence {
    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        List<String> res = subsequence.subsequence("abc");
        System.out.println(res);

        subsequence.process2("abc".toCharArray(), 0);

    }

    public List<String> subsequence(String s) {
        char[] chars = s.toCharArray();
        List<String> ans = new ArrayList<>();

        process(chars, 0, ans, "");
        return ans;
    }

    /**
     * index 来到了 chars 的终止位置就是 path
     *
     * @param chars 固定不变
     * @param index 此时来到的位置，要 or 不要
     * @param ans   放入之前做出的选择
     * @param path  记录目前形成的路径(子序列)
     */
    private void process(char[] chars, int index, List<String> ans, String path) {
        // index 来到了 chars 的终止位置就是 path
        if (index >= chars.length) { // base case
            ans.add(path);
            return;
        }
        process(chars, index + 1, ans, path);
        process(chars, index + 1, ans, path + chars[index]);
    }

    // only for test
    private void process2(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }
        process2(chars, i + 1); // 要
        char temp = chars[i];
        chars[i] = 0;
        process2(chars, i + 1);
        chars[i] = temp;
    }
}
