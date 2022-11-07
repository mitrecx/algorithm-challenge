package cn.mitrecx.leetcode1_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO

/**
 * 5. Longest Palindromic Substring
 *
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        List<Character> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c.equals(stack.peek())){
                result.add(stack.pop());
            }
        }
        return "";
    }
}
