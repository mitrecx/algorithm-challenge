package cn.mitrecx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode970 {
    // 优雅暴力
    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                result.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(result);
    }

    // 无脑暴力
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; Math.pow(y, j) < bound; j++) {
            for (int i = 0; Math.pow(x, i) + Math.pow(y, j) <= bound; i++) {
                set.add((int) (Math.pow(x, i) + Math.pow(y, j)));
                if (i > 0 && Math.pow(x, i) == 1) {
                    break;
                }
            }
            if (j > 0 && Math.pow(y, j) == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        LeetCode970 lc = new LeetCode970();
        int x = 2, y = 3, bound = 10;
        List<Integer> list = lc.powerfulIntegers2(x, y, bound);
        list.forEach(System.out::println);
    }
}
