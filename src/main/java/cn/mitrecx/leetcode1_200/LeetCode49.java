package cn.mitrecx.leetcode1_200;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        LeetCode49 leetCode49 = new LeetCode49();
        List<List<String>> r = leetCode49.groupAnagrams(strs);
        for (List<String> l : r) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            List<String> values = map.computeIfAbsent(sorted, sx -> new ArrayList<>());
            values.add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
