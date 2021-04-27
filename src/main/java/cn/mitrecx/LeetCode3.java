package cn.mitrecx;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    /**
     * Sliding Window
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> cache = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (cache.containsKey(s.charAt(right))) {
                // 新的 left 至少要大于等于原来的 left,
                // example1: "tmmabct", when index = 6(the last char), cache={(t,0),(m,2), (a,3),(b,4),(c,5)}, left=2,
                // although "t" in cache, we don't need to slide the window
                //
                // example2: "abba", cache会缓存最大下标数据, 在判断 下标3处的 a 时, 当前 cache={(a,0), (b,2)}, 当前 left=2
                // 如果不Math.max, 会出现 left 左移
                left = Math.max(cache.get(s.charAt(right)) + 1, left);
            }
            result = Math.max(result, right - left + 1);
            cache.put(s.charAt(right), right);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        // 5
        System.out.println(leetCode3.lengthOfLongestSubstring("tmmzuxt"));
        // 3
        System.out.println(leetCode3.lengthOfLongestSubstring("pwwkew"));
    }
}
