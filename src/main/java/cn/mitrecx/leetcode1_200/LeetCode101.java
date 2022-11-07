package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

/**
 * Title: 101. Symmetric Tree
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 二叉树(binary tree)
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 这个解法和第100题思路相同
     * @see LeetCode100#isSameTree(cn.mitrecx.TreeNode, cn.mitrecx.TreeNode)
     */
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }
}
