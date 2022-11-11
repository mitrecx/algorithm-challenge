package cn.mitrecx.newcoder.linkedlist;

import cn.mitrecx.ListNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Objects;

/**
 * BM5 合并k个已排序的链表
 */
public class Bm5 {
    public static void main(String[] args) {
        ListNode h1 = ListNode.construct(1, 2, 3);
        ListNode h2 = ListNode.construct(7, 9);
        ListNode h3 = ListNode.construct(3, 8);
        ArrayList<ListNode> lists = new ArrayList<>(3);
        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        Bm5 bm5 = new Bm5();
//        ListNode res = bm5.mergeKLists(lists);
        ListNode res = bm5.mergeKLists2(lists);
        ListNode.print(res);
    }

    // 解法 1: 每次遍历一遍 lists, 找到一个最小值, 遍历 m * n  次结束. (m 表示 lists.size(), n 表示 lists 的元素链表的平均长度)
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode valid = dummy;
        ArrayList<ListNode> ptrs = new ArrayList<>(lists.size());
        ptrs.addAll(lists);
        while (!ptrs.stream().allMatch(Objects::isNull)) {
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.size(); i++) {
                ListNode curr = ptrs.get(i);
                if (curr != null && curr.val < min) {
                    min = curr.val;
                    idx = i;
                }
            }
            valid.next = ptrs.get(idx);
            valid = ptrs.get(idx);
            ptrs.set(idx, ptrs.get(idx).next);
        }
        return dummy.next;
    }

    // 解法 2: lists 的元素链表两两合并, 看成归并排序
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        return mergeSort(lists, 0, lists.size() - 1);
    }

    private ListNode mergeSort(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        } else if (left > right) {
            return null;
        } else {
            int mid = (right - left) / 2 + left;
            ListNode l = mergeSort(lists, left, mid);
            ListNode r = mergeSort(lists, mid + 1, right);
            return merge(l, r);
        }
    }

    private ListNode merge(ListNode l, ListNode r) {
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        ListNode dummy = new ListNode(0);
        ListNode fin = dummy; //finished
        ListNode left = l, right = r;
        while (left != null && right != null) {
            if (left.val < right.val) {
                fin.next = left;
                fin = left;
                left = left.next;
            } else {
                fin.next = right;
                fin = right;
                right = right.next;
            }
        }
        if (left != null) {
            fin.next = left;
        } else {
            fin.next = right;
        }
        return dummy.next;
    }

}
