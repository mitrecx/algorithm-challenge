package cn.mitrecx;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: 142. Linked List Cycle II
 * Difficulty: Medium
 * Self Difficulty:
 * kw: hash, 快慢指针(这里没有用快慢指针, 用的话可以实现O(1)的空间复杂度)
 */
public class LeetCode142 {
    public static void main(String[] args) {
        LeetCode142 leetCode142 = new LeetCode142();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode r = leetCode142.detectCycle(head);
        System.out.println(r == null ? "null" : r.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        Set<ListNode> table = new HashSet<>();
        while (p != null) {
            if (table.contains(p)) {
                return p;
            }
            table.add(p);
            p = p.next;
        }
        return null;
    }
}
