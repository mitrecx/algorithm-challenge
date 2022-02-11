package cn.mitrecx;

/**
 * 83. Remove Duplicates from Sorted List
 * easy
 */
public class LeetCode83 {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        b.next = a;
        ListNode head = new ListNode(1);
        head.next = b;
        ListNode aa = new ListNode(3);
        ListNode bb = new ListNode(3);
        bb.next = aa;
        ListNode cc = new ListNode(2);
        cc.next = bb;
        ListNode dd = new ListNode(1);
        dd.next = cc;
        ListNode head1 = new ListNode(1);
        head1.next = dd;

        LeetCode83 leetCode83 = new LeetCode83();
        leetCode83.deleteDuplicates(head);
        leetCode83.print(head);

        leetCode83.deleteDuplicates(head1);
        leetCode83.print(head1);
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow;
            while (fast.next != null && fast.next.val == slow.val) {
                fast = fast.next;
            }
            slow.next = fast.next;
            slow = slow.next;
        }
        return head;
    }
}
