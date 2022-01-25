package cn.mitrecx;

/**
 * 9. Palindrome Number
 */
public class LeetCode9 {
    public static void main(String[] args) {
        LeetCode9 leetCode9 = new LeetCode9();
        System.out.println(leetCode9.isPalindrome(121));
        System.out.println(leetCode9.isPalindrome(-121));
        System.out.println(leetCode9.isPalindrome_2(121));
        System.out.println(leetCode9.isPalindrome_2(-121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int length = String.valueOf(x).length();
        if (length == 1) {
            return true;
        }

        int[] a = new int[length];
        int i = 0;
        while (x > 0) {
            a[i++] = x % 10;
            x = x / 10;
        }
        for (int j = 0; j < length / 2; j++) {
            if (a[j] != a[length - j - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return reverse - x == 0;
    }
}
