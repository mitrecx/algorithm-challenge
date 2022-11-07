package cn.mitrecx.leetcode1_200;

import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses
 */
public class LeetCode32 {
    public static void main(String[] args) {
        LeetCode32 leetCode32 = new LeetCode32();
        System.out.println(leetCode32.longestValidParentheses("(()"));
        System.out.println(leetCode32.longestValidParentheses(")()())"));
    }

    // 用栈存下标!
    // 栈底元素存 "最后一个没有匹配的右括号的下标"; 初始化栈顶元素为 -1
    // 遍历字符串, 是左括号时, 入栈;
    // 是右括号时, 出栈
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); //栈底元素存 "最后一个没有匹配的右括号的下标"
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
