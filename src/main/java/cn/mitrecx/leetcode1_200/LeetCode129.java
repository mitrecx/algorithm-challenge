package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

/**
 * Title: 129. Sum Root to Leaf Numbers
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: dfs(深度优先搜索), binary tree(二叉树)
 */
public class LeetCode129 {
    public static void main(String[] args) {
        LeetCode129 leetCode129 = new LeetCode129();
        //int[] root = {4,9,0,5,1};
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(leetCode129.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int currSum = prevSum * 10 + root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return currSum;
        }
        return dfs(root.left, currSum) + dfs(root.right, currSum);
    }
}
