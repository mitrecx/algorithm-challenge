package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        System.out.println(leetCode22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, r);
        return r;
    }

    /**
     * 回溯法:
     * 如果左括号数量不大于n, 我们可以放一个左括号.
     * 如果右括号数量小于左括号的数量, 我们可以放一个右括号.
     *
     * @param cur   当前括号的组合
     * @param open  左括号数量
     * @param close 右括号数量
     * @param max   最大括号对数(相当于, 最大左/右括号数量)
     * @param r     存放 解 的集合
     */
    private void backtrack(StringBuilder cur, int open, int close, int max, List<String> r) {
        if (cur.length() == 2 * max) {
            r.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(cur, open + 1, close, max, r);
            // 删除 本次 添加的左括号, 为后面添加右括号提供位置
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(cur, open, close + 1, max, r);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * 暴力法:
     * 生成所有 2^(2n) 个 '(' 和 ')' 字符构成的序列, 然后我们检查每一个是否有效即可
     * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
     */
    public List<String> generateParenthesis_0(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

}
