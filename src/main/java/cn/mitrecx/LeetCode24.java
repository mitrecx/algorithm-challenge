package cn.mitrecx;

/**
 * 24. Swap Nodes in Pairs
 */
public class LeetCode24 {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        b.next = a;
        ListNode c = new ListNode(2);
        c.next = b;
        ListNode d = new ListNode(1);
        d.next = c;
        ListNode.print(d);
        LeetCode24 leet = new LeetCode24();
        ListNode.print(leet.swapPairs(d));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        while (firstNode != null && secondNode != null) {
            // swap
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode;
            firstNode = firstNode.next;
            if (firstNode != null) {
                secondNode = firstNode.next;
            }
        }

        return dummy.next;
    }
}
