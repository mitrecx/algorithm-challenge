package cn.mitrecx;

public class LeetCode12 {

    public static void main(String[] args) {
        LeetCode12 leetCode12 = new LeetCode12();
        System.out.println(leetCode12.intToRoman(1994));
        System.out.println(leetCode12.intToRoman(58));
    }

    /**
     * 直接列举
     */
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"}; // 0,1000,2000,3000
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 0,100,200,300,...,900
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 0,10,20,30,...,90
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 0,1,2,3,...,9

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    /**
     * 贪心算法
     */
    public String intToRoman_2(int num) {
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                s.append("M");
                num -= 1000;
            } else if (num >= 900) {
                s.append("CM");
                num -= 900;
            } else if (num >= 500) {
                s.append("D");
                num -= 500;
            } else if (num >= 400) {
                s.append("CD");
                num -= 400;
            } else if (num >= 100) {
                s.append("C");
                num -= 100;
            } else if (num >= 90) {
                s.append("XC");
                num -= 90;
            } else if (num >= 50) {
                s.append("L");
                num -= 50;
            } else if (num >= 40) {
                s.append("XL");
                num -= 40;
            } else if (num >= 10) {
                s.append("X");
                num -= 10;
            } else if (num == 9) {
                s.append("IX");
                num -= 9;
            } else if (num >= 5) {
                s.append("V");
                num -= 5;
            } else if (num == 4) {
                s.append("IV");
                num -= 4;
            } else {
                s.append("I");
                num -= 1;
            }
        }
        return s.toString();
    }
}
