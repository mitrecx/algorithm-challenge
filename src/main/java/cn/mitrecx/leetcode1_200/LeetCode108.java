package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

/**
 * Title: 108. Convert Sorted Array to Binary Search Tree
 * Difficulty: Easy
 * Self Difficulty: 中
 * kw: 递归
 */
public class LeetCode108 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        LeetCode108 leetCode108 = new LeetCode108();
        TreeNode r = leetCode108.sortedArrayToBST(nums);
        System.out.println(r.val);
    }

    // return a height-balanced binary search tree
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }
}
