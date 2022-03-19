package cn.mitrecx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title: 151. Reverse Words in a String
 * Difficulty: Medium
 * Self Difficulty: 下
 * kw:
 */
public class LeetCode151 {
    public static void main(String[] args) {
        LeetCode151 leetCode151 = new LeetCode151();
        String s = "a good   example";
        System.out.println(leetCode151.reverseWords(s));
    }

    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
