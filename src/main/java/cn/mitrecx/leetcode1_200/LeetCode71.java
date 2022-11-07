package cn.mitrecx.leetcode1_200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. Simplify Path
 * <p>
 * 栈
 */
public class LeetCode71 {
    public static void main(String[] args) {
        LeetCode71 leetCode71 = new LeetCode71();
        System.out.println(leetCode71.simplifyPath("/home/"));
        System.out.println(leetCode71.simplifyPath("/../"));
        System.out.println(leetCode71.simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String path) {
        // split
        String[] pathElement = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String e : pathElement) {
            if ("..".equals(e)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                continue;
            }
            if (!e.isEmpty() && !".".equals(e)) {
                stack.offerLast(e);
            }
        }
        StringBuilder r = new StringBuilder();
        if (stack.isEmpty()) {
            r.append("/");
        } else {
            while (!stack.isEmpty()) {
                r.append("/");
                r.append(stack.pollFirst());
            }
        }
        return r.toString();
    }
}
