package cn.mitrecx.recursion;

/**
 * 范围尝试模型 1
 * 假设桌子上有一些纸牌, 排成一行, 每张纸牌上有一个正数,
 * 现在 A 和 B 两个人按下列规则做游戏(假设 A 和 B 都是绝顶聪明的人):
 * 1. 每次取牌时, 只能从最左侧 或 最右侧 取;
 * 2. A 和 B 轮流依次取牌, A 先取, B 再取, 然后再 A ...
 * 3. 取到牌的数字和最大者获胜.
 * 求 获胜者获取到的 数字和.
 * <p>
 * 例子:
 * 牌: [1, 20, 30, 5] 结果: 31 (备注: A 获胜)
 * 牌: [1, 20, 1] 结果: 20 (备注: B 获胜)
 */
public class Range_CarsInLine {

    // 解题思路:
    // 先手和后手会影响最终的结果.
    // 可以设 先手(first)函数为 f(arr, L, R), 表示在 arr 数组中的下标范围 [L, R], 先选 可以选择的最大和.
    // 后手(second)函数 s(arr, L, R), 表示在 arr 数组中的下标范围 [L, R], 后选 可以选择的最大和.
    // A 先选的结果为: f(arr, L, R) = max(arr[L] + s(arr, L+1, R), arr[R] + s(arr, L, R-1)).
    // B 后选的结果为: s(arr, L, R) = min(f(arr, L+1, R), f(arr, L, R-1)).
    // B 选择方案的解释: B 是后手, A是先手, A 一定会让自己的选择处于相对优势的状况, 所以 B 只能取两者 最小值.
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 20, 30, 5};
        Range_CarsInLine m = new Range_CarsInLine();
        System.out.println(m.win(test1));
        int[] test2 = new int[]{1, 20, 1};
        System.out.println(m.win(test2));
    }

    public int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int L = 0;
        int R = arr.length - 1;
        return Math.max(f(arr, L, R), s(arr, L, R));
    }

    private int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    private int s(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(
                f(arr, L + 1, R),
                f(arr, L, R - 1));
    }


}
