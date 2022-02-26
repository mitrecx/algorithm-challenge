package cn.mitrecx;

/**
 * Title: 110. Balanced Binary Tree
 * Difficulty: Easy
 * Self Difficulty: 上
 * kw: 二叉树, 递归
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * 注意是 "每个节点的左右两个子树的高度差不超过1"
 */
public class LeetCode110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LeetCode110 leetCode110 = new LeetCode110();
        System.out.println(leetCode110.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 树的深度, 最大深度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
