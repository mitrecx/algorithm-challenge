package cn.mitrecx;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 103. Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: 二叉树(binary tree)
 */
public class LeetCode103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        LeetCode103 leetCode103 = new LeetCode103();
        List<List<Integer>> ans = leetCode103.zigzagLevelOrder(root);
        ans.forEach(System.out::println);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.push(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue2.isEmpty()) {
                ans.add(process(queue1, queue2, false));
            } else {
                ans.add(process(queue2, queue1, true));
            }
        }
        return ans;
    }

    /**
     * @param currQueue      当前处理的queue, 里面存储了某一层的所有结点
     * @param auxiliaryQueue 辅助queue, 存储 currQueue 里结点的孩子结点
     * @param reverse        标识正逆序, false正序: left->right; true表示逆序: right->left
     */
    private List<Integer> process(Deque<TreeNode> currQueue, Deque<TreeNode> auxiliaryQueue, boolean reverse) {
        List<Integer> r = new ArrayList<>();
        Deque<Integer> temp = new LinkedList<>();
        while (!currQueue.isEmpty()) {
            TreeNode curr = currQueue.removeFirst();
            temp.addLast(curr.val);
            if (curr.left != null) {
                auxiliaryQueue.addLast(curr.left);
            }
            if (curr.right != null) {
                auxiliaryQueue.addLast(curr.right);
            }

        }
        while (!temp.isEmpty()) {
            if (reverse) {
                r.add(temp.removeLast());
            } else {
                r.add(temp.removeFirst());
            }
        }
        return r;
    }
}
