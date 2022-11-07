package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: 107. Binary Tree Level Order Traversal II
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 树的层次遍历, 广度优先搜索
 */
public class LeetCode107 {
    public static void main(String[] args) {
        LeetCode107 leetCode107 = new LeetCode107();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> ans = leetCode107.levelOrderBottom(root);
        ans.forEach(System.out::println);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        // 用一个 Queue 来实现广度优先搜索
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        while (!levelQueue.isEmpty()) {
            List<Integer> currAns = new ArrayList<>();
            int size = levelQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = levelQueue.poll();
                currAns.add(curr.val);
                if (curr.left != null) {
                    levelQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    levelQueue.offer(curr.right);
                }
            }
            ans.add(0, currAns);
        }
        return ans;
    }
}
