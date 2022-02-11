package cn.mitrecx;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * easy
 * 二叉树中序遍历
 */
public class LeetCode94 {
    List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        LeetCode94 leetCode94 = new LeetCode94();
        System.out.println(leetCode94.inorderTraversal(root));
        System.out.println(leetCode94.inorderTraversal_2(root));
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
        }
        return ans;
    }

    // 迭代
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
