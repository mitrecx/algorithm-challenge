package cn.mitrecx;

/**
 * 19. Remove Nth Node From End of List
 */
public class LeetCode19 {
    public static void main(String[] args) {

        LeetCode19 leetCode19 = new LeetCode19();
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4);
        b.next = a;
        ListNode c = new ListNode(3);
        c.next = b;
        ListNode d = new ListNode(2);
        d.next = c;
        ListNode e = new ListNode(1);
        e.next = d;

        leetCode19.print(e);
        ListNode r = leetCode19.removeNthFromEnd(e, 2);
        leetCode19.print(r);

        ListNode test2 = new ListNode(1);
        r = leetCode19.removeNthFromEnd(test2, 1);
        leetCode19.print(r);

        r = leetCode19.removeNthFromEnd(b, 2);
        leetCode19.print(r);
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 就是 单链表 查找倒数第 n 个元素的变体, 解题思路也是快慢指针.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode beforeSlow = null;
        while (fast != null) {
            fast = fast.next;
            beforeSlow = slow;
            slow = slow.next;
        }
        if (beforeSlow == null) {
            return slow.next;
        }
        beforeSlow.next = slow.next;
        return head;
    }

}
