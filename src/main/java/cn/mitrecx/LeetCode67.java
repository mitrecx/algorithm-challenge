package cn.mitrecx;

/**
 * 67. Add Binary
 */
public class LeetCode67 {
    public static void main(String[] args) {
        LeetCode67 leetCode67 = new LeetCode67();
//        System.out.println(leetCode67.addBinary("11", "1"));
        System.out.println(leetCode67.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        String r = "";
        for (int i = 0; i < n; i++) {
            int x = i >= a.length() ? 0 : a.charAt(a.length() - i - 1) - '0';
            int y = i >= b.length() ? 0 : b.charAt(b.length() - i - 1) - '0';
            int sum = x + y + carry;
            r = sum % 2 + r;
            carry = sum / 2;
        }
        if (carry > 0) {
            r = 1 + r;
        }
        return r;
    }
}
