package cn.mitrecx.leetcode1_200;

import cn.mitrecx.ListNode;

/**
 * Title: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 单链表
 */
public class LeetCode21 {
    public static void main(String[] args) {
        LeetCode21 leetCode21 = new LeetCode21();
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        b.next = a;
        ListNode list1 = new ListNode(1);
        list1.next = b;
        ListNode.print(list1);

        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);
        d.next = c;
        ListNode list2 = new ListNode(1);
        list2.next = d;
        ListNode.print(list2);

        ListNode r = leetCode21.mergeTwoLists(list1, list2);
        ListNode.print(r);
    }


    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
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
