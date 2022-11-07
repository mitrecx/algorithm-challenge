package cn.mitrecx.leetcode1_200;

import cn.mitrecx.ListNode;

/**
 * Title: 148. Sort List
 * Difficulty: Medium
 * Self Difficulty: 上
 * kw: 单链表, 归并排序, 快慢指针
 *
 * @see cn.mitrecx.sort.MergeSort
 * @see LeetCode21
 */
public class LeetCode148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode.print(head);
        LeetCode148 leetCode148 = new LeetCode148();
        ListNode.print(leetCode148.sortList(head));
    }

    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        return sortList(head, tail);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        // 归并排序
        ListNode mid = getMiddleNode(head, tail);
        ListNode midRight = mid.next;
        mid.next = null;

        ListNode ln1 = sortList(head, mid); // 左边

        ListNode ln2 = sortList(midRight, tail); // 右边

        return merge(ln1, ln2); // 合并
    }

    /**
     * @see LeetCode143#getMiddleNode(cn.mitrecx.ListNode)
     */
    public ListNode getMiddleNode(ListNode head, ListNode tail) { // 左中
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * @see LeetCode21#mergeTwoLists(cn.mitrecx.ListNode, cn.mitrecx.ListNode)
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return dummyHead.next;
    }
}
