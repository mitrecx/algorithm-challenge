package cn.mitrecx;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 102. Binary Tree Level Order Traversal
 * Difficulty: Medium
 * Self Difficulty: 下
 * kw: 二叉树(binary tree)
 */
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LeetCode102 leetCode102 = new LeetCode102();
        List<List<Integer>> ans = leetCode102.levelOrder(root);
        ans.forEach(s -> System.out.println(s));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.push(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue2.isEmpty()) {
                ans.add(process(queue1, queue2));
            } else {
                ans.add(process(queue2, queue1));
            }
        }
        return ans;
    }

    /**
     * @param currQueue      当前处理的queue, 里面存储了某一层的所有结点
     * @param auxiliaryQueue 辅助queue, 存储 currQueue 里结点的孩子结点
     */
    private List<Integer> process(Deque<TreeNode> currQueue, Deque<TreeNode> auxiliaryQueue) {
        List<Integer> r = new ArrayList<>();
        while (!currQueue.isEmpty()) {
            TreeNode curr = currQueue.removeFirst();
            r.add(curr.val);
            if (curr.left != null) {
                auxiliaryQueue.addLast(curr.left);
            }
            if (curr.right != null) {
                auxiliaryQueue.addLast(curr.right);
            }
        }
        return r;
    }
}
