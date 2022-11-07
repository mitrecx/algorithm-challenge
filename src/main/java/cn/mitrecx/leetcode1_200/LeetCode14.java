package cn.mitrecx.leetcode1_200;

/**
 * 14. Longest Common Prefix
 */
public class LeetCode14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"ab", "a"};
        LeetCode14 leetCode14 = new LeetCode14();
        System.out.println(leetCode14.longestCommonPrefix(strs));
        System.out.println(leetCode14.longestCommonPrefix(strs2));
    }

    public String longestCommonPrefix(String[] strs) {
        String r = strs[0];
        if (strs.length == 1) {
            return r;
        }
        for (int i = 1; i < strs.length; i++) {
            int len = Math.min(r.length(), strs[i].length());
            String temp = "";
            for (int j = 0; j < len; j++) {
                if (r.charAt(j) == strs[i].charAt(j)) {
                    temp += r.charAt(j);
                } else {
                    if (temp.equals("")) {
                        return "";
                    }
                    break;
                }
            }
            r = temp;
        }
        return r;
    }


    public String longestCommonPrefix_2(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
