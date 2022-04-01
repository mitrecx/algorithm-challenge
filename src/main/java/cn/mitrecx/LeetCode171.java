package cn.mitrecx;

/**
 * Title: 171. Excel Sheet Column Number
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 进制转换
 */
public class LeetCode171 {
    public static void main(String[] args) {
        LeetCode171 leetCode171 = new LeetCode171();
        System.out.println(leetCode171.titleToNumber("AB"));
    }

    // 26 进制转 10 进制
    public int titleToNumber(String columnTitle) {
        int r = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            // 'A' = 1
            int columnBit = columnTitle.charAt(i) - 'A' + 1;
            r += columnBit * Math.pow(26, columnTitle.length() - i - 1);
        }
        return r;
    }
}
