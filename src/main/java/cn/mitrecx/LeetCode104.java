package cn.mitrecx;

/**
 * Title: 104. Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Self Difficulty: 下
 * kw: 二叉树(Binary Tree), 入门递归
 */
public class LeetCode104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        LeetCode104 leetCode104 = new LeetCode104();
        System.out.println(leetCode104.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int i) {
        if (root != null) {
            return Math.max(maxDepth(root.left, i + 1), maxDepth(root.right, i + 1));
        }
        return i;
    }
}
