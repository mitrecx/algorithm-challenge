package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

/**
 * Title: 100. Same Tree
 * Difficulty: Easy
 * Self Difficulty:
 * kw: 二叉树(binary tree)
 */
public class LeetCode100 {
    public static void main(String[] args) {

    }

    /**
     * @see LeetCode101#check(cn.mitrecx.TreeNode, cn.mitrecx.TreeNode)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
