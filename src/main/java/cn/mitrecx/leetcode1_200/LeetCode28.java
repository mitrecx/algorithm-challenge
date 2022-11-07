package cn.mitrecx.leetcode1_200;

/**
 * 28. Implement strStr()
 */
public class LeetCode28 {
    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();
        String haystack = "hellloWorld", needle = "lloW";
        String haystack1 = "aaaaa", needle1 = "bba";
        String haystack2 = "", needle2 = "";
        System.out.println(leetCode28.strStr_2(haystack, needle));
        System.out.println(leetCode28.strStr(haystack1, needle1));
        System.out.println(leetCode28.strStr(haystack2, needle2));
    }

    /**
     * 不讲码德解法
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 巧妙的解法
     */
    public int strStr_2(String haystack, String needle) {
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        // 计算pattern中字符出现的次数, 计算结果用于节省判断重复字符的时间
        int lps[] = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            return i - pattern.length;
        }
        return -1;
    }

    /**
     * 计算每个字符出现的次数.
     * 比如 pattern = [a,a,a, b, c, d,d]
     * 计算结果 = [0,1,2, 0, 0, 0,1]
     */
    private int[] computeTemporaryArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
