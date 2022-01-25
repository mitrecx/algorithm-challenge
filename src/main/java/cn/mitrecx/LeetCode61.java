package cn.mitrecx;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 */
public class LeetCode61 {
    public static void main(String[] args) {
        // 1->2->3->4->5
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l2);
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        LeetCode61 leetCode61 = new LeetCode61();
        p = leetCode61.rotateRight(head, 1);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast.next == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
        }

        ListNode slow = head;
        if (fast == slow) {
            return slow;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
