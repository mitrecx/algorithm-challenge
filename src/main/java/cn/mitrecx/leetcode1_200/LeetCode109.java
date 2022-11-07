package cn.mitrecx.leetcode1_200;

import cn.mitrecx.ListNode;
import cn.mitrecx.TreeNode;

/**
 * Title: 109. Convert Sorted List to Binary Search Tree
 * Difficulty: Medium
 * Self Difficulty: 上
 * kw: 递归, 双指针
 */
public class LeetCode109 {
    public static void main(String[] args) {
        //-10,-3,0,5,9
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        LeetCode109 leetCode109 = new LeetCode109();
        TreeNode r = leetCode109.sortedListToBST(head);
        System.out.println(r.val);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    /**
     * @param left  左区间 inclusive
     * @param right 右区间 exclusive
     */
    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    /**
     * 快慢指针找到中点
     */
    public ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        // 加上最后一个条件相当于向下取整, 不加相当于向上取整, 无论加不加, 都不影响计算结果
        while (fast != right && fast.next != right /*&& fast.next.next != right*/) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
