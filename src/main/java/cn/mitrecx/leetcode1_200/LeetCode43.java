package cn.mitrecx.leetcode1_200;

/**
 * 43. Multiply Strings
 */
public class LeetCode43 {
    public static void main(String[] args) {
        LeetCode43 leetCode43 = new LeetCode43();
        System.out.println(leetCode43.multiply("123",
                "456"));
    }

    public String multiply(String num1, String num2) {
        // 如果可以用 BigDecimal, 一行代码就完事了
        // return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();

        // 思路: 排竖式, 就是小学2年级学的用 竖式 算 乘法
        // 竖式可以一位一位乘, 结果可以一位一位的加, 除了当前计算的位, 其他都用字符串表示.
        // 这样可以做到 任意长度的数相乘
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length(), length2 = num2.length();
        StringBuilder result = new StringBuilder("0");
        for (int j = length2 - 1; j >= 0; j--) {
            StringBuilder currRow = new StringBuilder();

            for (int i = length2 - 1; i > j; i--) {
                currRow.append("0");
            }

            int y = num2.charAt(j) - '0';
            int carry = 0; // 进位
            for (int i = length1 - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                int product = x * y + carry;
                currRow.append(product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                currRow.append(carry);
            }
            result = add(result, currRow.reverse());
        }
        return result.toString();
    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder r = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            r.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return r.reverse();
    }
}
