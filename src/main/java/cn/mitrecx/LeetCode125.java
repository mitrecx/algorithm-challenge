package cn.mitrecx;

/**
 * Title: 125. Valid Palindrome
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 双指针
 */
public class LeetCode125 {
    public static void main(String[] args) {
        LeetCode125 leetCode125 = new LeetCode125();
        System.out.println(leetCode125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leetCode125.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
