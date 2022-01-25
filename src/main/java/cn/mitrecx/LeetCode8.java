package cn.mitrecx;

/**
 * 8. String to Integer (atoi)
 */
public class LeetCode8 {
    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();
        System.out.println(leetCode8.myAtoi("42"));
        System.out.println(leetCode8.myAtoi("   -42"));
        System.out.println(leetCode8.myAtoi("4193 with words"));
        System.out.println(leetCode8.myAtoi("-2147483648"));
        System.out.println(leetCode8.myAtoi_2("-2147483648"));
        System.out.println(leetCode8.myAtoi_2("2147483647"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int myAtoi(String s) {
        s = s.trim();
        String digits = "";
        int flag = 1;
        if (s.startsWith("-")) {
            digits = "-";
            flag = -1;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            s = s.substring(1);
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // '0' -> 48
            // '9' -> 57
            if ((int) c < 48 || (int) c > 57) {
                break;
            }
//            if()
            digits = digits + c;
            if (result == 0) {
                result = Integer.parseInt(digits);
            } else {
                int tempResult = result * 10 + Character.getNumericValue(c) * flag;
                if (tempResult / 10 != result) {
                    if (flag == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                result = tempResult;
            }
        }
        return result;
    }

    public int myAtoi_2(String s) {
        int len = s.length();
        int res = 0;
        if (len == 0) {
            return res;
        }

        boolean isNegative = false;
        int i = 0;
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        if (i == len) {
            return res;
        }
        if (i < len) {
            if (s.charAt(i) == '-') {
                isNegative = true;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }
        while (i < len) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // 数字 严格"大于" Integer.MAX_VALUE 时, 才退出; "等于" 不退出.
            // 所以,
            // 若 res 最终结果是 Integer.MIN_VALUE 则在这里会退出.
            // 若 res 最终结果是 Integer.MAX_VALUE 则在这里不会退出.
            if (Integer.MAX_VALUE / 10 < res ||
                    Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            res = (res * 10) + digit;
            i++;
        }
        if (isNegative) {
            return (res * -1);
        }
        return res;
    }
}
