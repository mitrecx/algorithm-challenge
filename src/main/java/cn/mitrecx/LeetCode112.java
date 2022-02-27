package cn.mitrecx;

/**
 * Title: 112. Path Sum
 * Difficulty: Easy
 * Self Difficulty: 中
 * kw: 递归
 */
public class LeetCode112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        LeetCode112 leetCode112 = new LeetCode112();
        System.out.println(leetCode112.hasPathSum(root, 5));
        System.out.println(leetCode112.hasPathSum(root, 4));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
