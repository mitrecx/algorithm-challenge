package cn.mitrecx.leetcode1_200;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/description/">6. Zigzag Conversion</a>
 */
public class LeetCode6 {

    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
        String r1 = leetCode6.convert("PAYPALISHIRING", 3);
        String a1 = "PAHNAPLSIIGYIR";
        System.out.println(r1 + " == " + a1 + "  " + (a1.equals(r1)));
        String r2 = leetCode6.convert("PAYPALISHIRING", 4);
        String a2 = "PINALSIGYAHRPI";
        System.out.println(r2 + " == " + a2 + "  " + (a2.equals(r2)));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<Character>[] result = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            result[i] = new ArrayList<>();
        }

        int pointer = 1;
        //  控制在 y 轴 上下移动方向
        int increment = 1;
        for (int i = 0; i < s.length(); i++) {
            if (pointer == 1) {
                result[pointer - 1].add(s.charAt(i));
                pointer++;
                increment = 1;
                continue;
            }
            if (pointer == numRows) {
                result[pointer - 1].add(s.charAt(i));
                pointer--;
                increment = 0;
                continue;
            }
            result[pointer - 1].add(s.charAt(i));
            if (increment == 1) {
                pointer++;
            } else {
                pointer--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(convert2String(result[i]));
        }
        return sb.toString();
    }

    private String convert2String(List<Character> chars) {
        StringBuilder sb = new StringBuilder(chars.size());
        for (Character c : chars)
            sb.append(c.charValue());

        return sb.toString();
    }

}
