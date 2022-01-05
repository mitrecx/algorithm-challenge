package cn.mitrecx;

public class LeetCode13 {
    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.println(leetCode13.romanToInt("III"));
        System.out.println(leetCode13.romanToInt("LVIII"));
        System.out.println(leetCode13.romanToInt("MCMXCIV"));
        System.out.println(leetCode13.romanToInt_2("III"));
        System.out.println(leetCode13.romanToInt_2("LVIII"));
        System.out.println(leetCode13.romanToInt_2("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int r = 0;
        while (s.length() > 0) {
            if (s.length() > 1 && s.charAt(0) == 'C' && s.charAt(1) == 'M') {
                r += 900;
                s = s.substring(2);
                continue;
            }
            if (s.length() > 1 && s.charAt(0) == 'C' && s.charAt(1) == 'D') {
                r += 400;
                s = s.substring(2);
                continue;
            }
            if (s.length() > 1 && s.charAt(0) == 'X' && s.charAt(1) == 'C') {
                r += 90;
                s = s.substring(2);
                continue;
            }
            if (s.length() > 1 && s.charAt(0) == 'X' && s.charAt(1) == 'L') {
                r += 40;
                s = s.substring(2);
                continue;
            }
            if (s.length() > 1 && s.charAt(0) == 'I' && s.charAt(1) == 'X') {
                r += 9;
                s = s.substring(2);
                continue;
            }
            if (s.length() > 1 && s.charAt(0) == 'I' && s.charAt(1) == 'V') {
                r += 4;
                s = s.substring(2);
                continue;
            }
            if (s.charAt(0) == 'M') {
                r += 1000;
                s = s.substring(1);
                continue;
            }
            if (s.charAt(0) == 'D') {
                r += 500;
                s = s.substring(1);
                continue;
            }
            if (s.charAt(0) == 'C') {
                r += 100;
                s = s.substring(1);
                continue;
            }
            if (s.charAt(0) == 'L') {
                r += 50;
                s = s.substring(1);
                continue;
            }
            if (s.charAt(0) == 'X') {
                r += 10;
                s = s.substring(1);
                continue;
            }
            if (s.charAt(0) == 'V') {
                r += 5;
                s = s.substring(1);
                continue;
            }
            if (s.charAt(0) == 'I') {
                r += 1;
                s = s.substring(1);
            }
        }
        return r;
    }

    public int romanToInt_2(String s) {
        int prev = char2int(s.charAt(0));
        int res = prev;
        for (int i = 1; i < s.length(); i++) {
            final char c = s.charAt(i);
            int cur = char2int(c);
            if (prev < cur) {
                res -= 2 * prev;
            }
            res += cur;
            prev = cur;
        }
        return res;
    }
    private static int char2int(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        throw new RuntimeException();
    }
}
