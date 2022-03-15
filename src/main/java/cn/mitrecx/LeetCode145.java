package cn.mitrecx;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 145. Binary Tree Postorder Traversal
 * Difficulty: Easy
 * Self Difficulty: 中
 * kw: 二叉树后序遍历
 *
 * @see LeetCode144
 */
public class LeetCode145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        LeetCode145 leetCode145 = new LeetCode145();
        System.out.println(leetCode145.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        postorderTraversal(root, r);
        return r;
    }

    private void postorderTraversal(TreeNode root, List<Integer> r) {
        if (root != null) {
            postorderTraversal(root.left, r);
            postorderTraversal(root.right, r);
            r.add(root.val);
        }
    }

    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) {
            return r;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        // 记录, 用于和根结点的右孩子对比
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 当前出队的根结点需要 放入 r 中的条件: root 没有右子树, 或 root 的右孩子已经被放入 r 中
            if (root.right == null || root.right == prev) {
                prev = root;
                r.add(root.val);
                root = null; // root 要置空, 不然死循环
            } else {
                stack.push(root); // 右子树还没有遍历, 把根结点放回去, 先遍历有子树
                root = root.right;
            }
        }
        return r;
    }

}
