package cn.mitrecx;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 */
public class LeetCode20 {
    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid("()[]{}"));
        System.out.println(leetCode20.isValid("[()]"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                Character pop = stack.pollLast();
                if (pop == null) {
                    return false;
                }
                if (pop == '(' && c != ')'
                        || pop == '[' && c != ']'
                        || pop == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.size() <= 0;
    }
}
