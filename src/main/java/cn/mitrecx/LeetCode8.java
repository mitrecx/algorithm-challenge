package cn.mitrecx;

public class LeetCode8 {
    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();
        System.out.println(leetCode8.myAtoi("42"));
        System.out.println(leetCode8.myAtoi("   -42"));
        System.out.println(leetCode8.myAtoi("4193 with words"));
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
}
