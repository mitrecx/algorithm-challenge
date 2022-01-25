package cn.mitrecx;

/**
 * 50. Pow(x, n)
 */
public class LeetCode50 {
    public static void main(String[] args) {
        LeetCode50 leetCode50 = new LeetCode50();
        System.out.println(leetCode50.myPow(2.0, 10));
        System.out.println(leetCode50.myPow(2.0, -2));
    }

    public double myPow(double x, int n) {
        return n > 0 ? calculate(x, n) : 1 / calculate(x, -n);
    }

    /**
     * 二分法进行指数运算
     *
     * @param x 底数
     * @param n 指数
     * @return
     */
    private double calculate(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = calculate(x, n / 2);
        // 指数为奇数时, 二分结果是: y * y * x
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
