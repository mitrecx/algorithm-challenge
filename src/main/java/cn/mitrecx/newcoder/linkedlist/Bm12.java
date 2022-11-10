package cn.mitrecx.newcoder.linkedlist;

import cn.mitrecx.ListNode;

/**
 * BM12 单链表的排序
 * <p>
 * 给定一个节点数为n的无序单链表，对其按升序排序。
 * 链表长度：0 < n ≤ 100000
 * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
 */
public class Bm12 {

    public static void main(String[] args) {
        // 输入：[1,3,2,4,5]
        // 返回值：{1,2,3,4,5}
        Bm12 bm12 = new Bm12();
        ListNode head = ListNode.construct(1, 3, 2, 4, 5);
        ListNode.print("输入", head);

        ListNode head2 = bm12.mergeSort(head);
        ListNode.print("返回", head2);
    }

    /**
     * 解题思路: 归并排序
     */
    private ListNode mergeSort(ListNode head) {
        // 把链表分成两部分, 再应用归并排序
        ListNode t = midBefore(head);
        ListNode mid = t.next;
        if (t == head && mid == null) { // 只有一个元素, 不用排序
            return head;
        }
        t.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }

    private ListNode midBefore(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode left = list1, right = list2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            } else {
                curr.next = right;
                curr = curr.next;
                right = right.next;
            }
        }
        if (left != null) {
            curr.next = left;
        } else {
            curr.next = right;
        }
        return head.next;
    }
}
