package cn.mitrecx;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> cache = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!cache.add(s.charAt(j))) {
                    result = Math.max(result, cache.size());
                    cache.clear();
                    break;
                }
            }
        }
        result = Math.max(result, cache.size());
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring(s));
    }
}
