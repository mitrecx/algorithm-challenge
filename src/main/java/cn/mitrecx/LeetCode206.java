package cn.mitrecx;

/**
 * Title: 206. Reverse Linked List
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 链表
 *
 * @see LeetCode92
 */
public class LeetCode206 {
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
        LeetCode206 leetCode206 = new LeetCode206();
        ListNode r = leetCode206.reverseList(l1);
        ListNode.print(r);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
