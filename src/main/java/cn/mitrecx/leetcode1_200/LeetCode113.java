package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 113. Path Sum II
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 递归, 深度优先搜索dfs, 回溯
 */
public class LeetCode113 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        LeetCode113 leetCode113 = new LeetCode113();
        List<List<Integer>> rs = leetCode113.pathSum(root, 22);
        for (List<Integer> r : rs) {
            System.out.println(r);
        }
    }
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        pathSum(root, targetSum, result);
        return ans;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                result.add(root.val);
                ans.add(new ArrayList<>(result));
                result.remove(result.size() - 1);
            }
            return;
        }
        targetSum = targetSum - root.val;
        result.add(root.val);
        if (root.left != null) {
            pathSum(root.left, targetSum, result);
        }
        if (root.right != null) {
            pathSum(root.right, targetSum, result);
        }
        result.remove(result.size() - 1);
    }

    // 以下代码是上面的简介版
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();
    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }


}
