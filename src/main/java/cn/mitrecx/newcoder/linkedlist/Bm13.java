package cn.mitrecx.newcoder.linkedlist;

import cn.mitrecx.ListNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

/**
 * BM13 判断一个链表是否为回文结构
 */
public class Bm13 {
    public static void main(String[] args) {
        Bm13 bm13 = new Bm13();
        System.out.println(
                bm13.isPail(ListNode.construct(1,2,3,2,1)));

        System.out.println(
                bm13.isPail(ListNode.construct(1,2,2,1)));
        System.out.println(
                bm13.isPail(ListNode.construct(1,2,1,1)));
    }

    public boolean isPail(ListNode head) {
        // write code here
        if (head == null) {
            return false;
        }
        ListNode mid = midBefore(head);
        ListNode after = mid.next;
        // if (mid == after && after == null) { // 只有一个结点
        //     return true;
        // }
        after = reverse(after);
        ListNode.print(after);
        while (after != null) {
            if (after.val != head.val) {
                return false;
            }
            after = after.next;
            head = head.next;
        }

        return true;
    }

    /**
     * 此方法返回链表的中间结点, 如果中间结点有两个 则 返回靠左的一个
     * {1,2,3} 返回 2
     * {1,2,3,4} 返回 2
     */
    private ListNode midBefore(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head.next, left = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = left;
            if (left == head) {
                left.next = null;
            }
            left = curr;
            curr = temp;
        }
        return left;
    }
}
