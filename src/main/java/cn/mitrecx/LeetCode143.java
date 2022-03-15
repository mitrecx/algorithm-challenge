package cn.mitrecx;

/**
 * Title: 143. Reorder List
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: 双指针(two pointers), 翻转链表(Reverse Linked List)
 *
 * @see LeetCode206
 */
public class LeetCode143 {
    public static void main(String[] args) {
        LeetCode143 leetCode143 = new LeetCode143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode.print(head);

        leetCode143.reorderList(head);

        ListNode.print(head);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode middle = getMiddleNode(head);
        // 从 middle 的后一个开始翻转
        ListNode reversed = reverseList(middle.next);
        // middle 后面断开
        middle.next = null;
        ListNode h = head;
        // 把前半部分和后半部分 交叉合并
        mergeList(h, reversed);
    }

    public ListNode getMiddleNode(ListNode head) { // 左中
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode t1 = null, t2 = null;
        while (l1 != null && l2 != null) {
            t1 = l1.next;
            t2 = l2.next;

            l1.next = l2;
            l1 = t1;
            l2.next = l1;
            l2 = t2;
        }
    }
}
