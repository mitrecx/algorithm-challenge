package cn.mitrecx.recursion;

/**
 * 2022-11-9, 面字节被面到的题:
 * 规定 1 和 A 对应, 2 和 B 对应, 3 和 C 对应, 1-26 对应 26 个字母
 * 那么一个数字字符串比如 “111”, 就可以转化为 “AAA”, 或者是 “KA”.
 * 给定一个只有数字组成的字符串 str, 问返回有多少种转化结果?
 */
public class LeftToRight2 {
    public static void main(String[] args) {
        LeftToRight2 leftToRight2 = new LeftToRight2();
        String test1 = "111";
        int res = leftToRight2.process(test1.toCharArray(), 0);
        System.out.println(res);

        String test2 = "11111";
        int res2 = leftToRight2.process(test2.toCharArray(), 0);
        System.out.println(res2);
    }

    // char[0...index-1] 已经处理完了, 固定了, 不用再考虑 index 之前的数据了.
    // 现在看是处理 index 位置, index 以后有多少种情况
    private int process(char[] chars, int index) {
        if (index >= chars.length) { // base case;
            return 1;
        }
        if (chars[index] == '0') { // 非法情况
            return 0;
        }
        int one = process(chars, index + 1);
        int two = 0;
        if (index + 1 < chars.length) {
            char v1 = chars[index]; // 当前位置的值
            char v2 = chars[index + 1]; // 下一给位置的值
            // 当前位置和下一个位置是否可以组合
            if (v1 == '1' || (v1 == '2' && v2 <= '6')) {
                two = process(chars, index + 2);
            }
        }
        return one + two;
    }
}
