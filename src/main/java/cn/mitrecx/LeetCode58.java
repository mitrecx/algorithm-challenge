package cn.mitrecx;

/**
 * 58. Length of Last Word
 */
public class LeetCode58 {
    public static void main(String[] args) {
        LeetCode58 leetCode58 = new LeetCode58();
        System.out.println(leetCode58.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        if (!s.contains(" ")) {
            return s.length();
        }
        s = s.trim();
        System.out.println(s.lastIndexOf(" "));
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }
}
