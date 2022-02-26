package cn.mitrecx;

/**
 * Title: 111. Minimum Depth of Binary Tree
 * Difficulty: Easy
 * Self Difficulty: 中
 * kw: 递归
 */
public class LeetCode111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LeetCode111 leetCode111 = new LeetCode111();
        System.out.println(leetCode111.minDepth(root));
    }

    // 最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
}
