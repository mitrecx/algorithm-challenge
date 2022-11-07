package cn.mitrecx.leetcode1_200;

/**
 * Title: 165. Compare Version Numbers
 * Difficulty: Medium
 * Self Difficulty:
 * kw: two-pointers
 */
public class LeetCode165 {
    public static void main(String[] args) {
        LeetCode165 leetCode165 = new LeetCode165();
        System.out.println(leetCode165.compareVersion("1.01", "1.0001"));
        System.out.println(leetCode165.compareVersion("1.0", "1.0.0"));
        System.out.println(leetCode165.compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1Array = version1.split("\\.");
        String[] v2Array = version2.split("\\.");
        int len = Math.max(v1Array.length, v2Array.length);
        for (int i = 0; i < len; i++) {
            //  If a version number does not specify a revision at an index,
            //  then treat the revision as 0.
            int x = 0, y = 0;
            if (i < v1Array.length) {
                x = Integer.parseInt(v1Array[i]);
            }
            if (i < v2Array.length) {
                y = Integer.parseInt(v2Array[i]);
            }
            if (x != y) {
                return x < y ? -1 : 1;
            }
        }
        return 0;
    }

    // better, space complexity: O(1)
    // two-pointers
    public int compareVersion_2b(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int x = 0, y = 0;
            for (; i < version1.length() && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++; // skip dot

            for (; j < version2.length() && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++; // skip dot

            if (x != y) {
                return x < y ? -1 : 1;
            }
        }
        return 0;
    }
}
