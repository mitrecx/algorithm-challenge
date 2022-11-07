package cn.mitrecx.leetcode201_400;

import cn.mitrecx.ListNode;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.next == null) {
                break;
            }
        }
        ListNode p = reverse(slow.next);
        while (p != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(1, null);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l2);

        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        LeetCode234 leetCode234 = new LeetCode234();
        System.out.println(leetCode234.isPalindrome(head));
    }
}
