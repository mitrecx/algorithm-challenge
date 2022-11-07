package cn.mitrecx.leetcode1_200;

import cn.mitrecx.ListNode;

/**
 * Title: 92. Reverse Linked List II
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 翻转链表
 *
 * @see cn.mitrecx.leetcode201_400.LeetCode206
 */
public class LeetCode92 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode r = leetCode92.reverseBetween(l1, 1, 2);
        ListNode.print(r);

        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(5);
        ln1.next = ln2;
        r = leetCode92.reverseBetween(ln1, 1, 2);
        ListNode.print(r);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 假设 head = node(1) -> node(2) -> node(3) -> node(4) -> node(5); left = 2; right = 4;
        // 那么 firstBreak = node(1), reversedTail = node(2), 这两个结点用于把未反转和翻转后的链表拼接起来
        ListNode firstBreak = dummy;
        ListNode reversedTail = firstBreak.next;

        int pos = 1;
        ListNode p = head;
        ListNode n = p.next;
        while (n != null) {
            if (pos >= left) {
                if (pos == left) { // 翻转后的尾结点, 尾结点next置为null, 防止只有两个结点时形成环(cycle)
                    p.next = null;
                }
                if (pos < right) {
                    // reverse
                    ListNode nn = n.next;
                    n.next = p;
                    p = n;
                    n = nn;
                    pos++;
                    continue;
                } else {
                    break;
                }
            } else {
                firstBreak = firstBreak.next;
                reversedTail = firstBreak.next;
            }
            pos++;
            p = n;
            n = n.next;
        }
        firstBreak.next = p;
        if (reversedTail != null) {
            reversedTail.next = n;
        }
        return dummy.next;
    }
}
