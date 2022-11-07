package cn.mitrecx.leetcode1_200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 150. Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Self Difficulty: 下
 * kw: stack(栈)
 */
public class LeetCode150 {
    public static void main(String[] args) {
        LeetCode150 leetCode150 = new LeetCode150();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(leetCode150.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            switch (token) {
                case "+":
                    stack.push(num1 + num2);
                    break;
                case "-":
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(num1 * num2);
                    break;
                case "/":
                    stack.push(num1 / num2);
                    break;
                default:
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }
}
