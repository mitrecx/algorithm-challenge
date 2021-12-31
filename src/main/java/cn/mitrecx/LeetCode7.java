package cn.mitrecx;

public class LeetCode7 {
    public static void main(String[] args) {
        LeetCode7 lc = new LeetCode7();
        int x = -123;
        System.out.println(x % 10);
        System.out.println(x / 10);

        System.out.println(lc.reverse(1534236469));
        System.out.println(lc.reverse(1230));
        System.out.println(lc.reverse(-1230));
        System.out.println(lc.reverse(-12301));
    }


    public int reverse(int x) {
        int result = 0;
        int remainder = 0;
        while (x != 0) {
            remainder = x % 10;
            x = x / 10;
            int tempResult = result * 10 + remainder;
            if (tempResult / 10 != result) {
                return 0;
            }
            result = tempResult;
        }
        return result;
    }
}
