package cn.mitrecx;

/**
 * Title: 141. Linked List Cycle
 * Difficulty: Easy
 * Self Difficulty:
 * kw: two-pointer, slow & fast pointers, 快慢指针
 */
public class LeetCode141 {
    public static void main(String[] args) {
        LeetCode141 leetCode141 = new LeetCode141();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(leetCode141.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
