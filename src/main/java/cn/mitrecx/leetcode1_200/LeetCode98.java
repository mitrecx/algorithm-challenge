package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * Medium
 * 递归
 */
public class LeetCode98 {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(2);
        r.left = new TreeNode(1);
        r.right = new TreeNode(3);
        LeetCode98 leetCode98 = new LeetCode98();
        System.out.println(leetCode98.isValidBST(r));

        TreeNode r2 = new TreeNode(5);
        r2.left = new TreeNode(1);
        r2.right = new TreeNode(4);
        r2.right.left = new TreeNode(3);
        r2.right.right = new TreeNode(6);
        System.out.println(leetCode98.isValidBST(r2));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }
        return isValidBST(node.left, minValue, node.val) && isValidBST(node.right, node.val, maxValue);
    }
}
