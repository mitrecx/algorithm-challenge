package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 114. Flatten Binary Tree to Linked List
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: pre-order traversal(先序遍历)
 */
public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(6);
        LeetCode114 leetCode114 = new LeetCode114();
        leetCode114.flatten_2b(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    // 偷懒的做法
    public void flatten(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        preorderTraversal(root, result);
        for (int i = 1; i < result.size(); i++) {
            TreeNode prev = result.get(i - 1);
            prev.right = result.get(i);
            prev.left = null;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> result) {
        if (root != null) {
            result.add(root);
            preorderTraversal(root.left, result);
            preorderTraversal(root.right, result);
        }
    }

    // 动脑筋的做法
    // 处理当前结点 curr 时, 总是把 curr.right 链接到 curr.left 在先序遍历的最后一个结点上(predecessor).
    public void flatten_2b(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                if (curr.right == null) {
                    curr.right = curr.left;
                    curr.left = null;
                } else {
                    TreeNode next = curr.left;
                    TreeNode predecessor = next;
                    // 找 predecessor
                    while (predecessor.left != null || predecessor.right != null) {
                        if (predecessor.right != null) {
                            predecessor = predecessor.right;
                        } else {
                            predecessor = predecessor.left;
                        }
                    }
                    predecessor.right = curr.right;
                    curr.left = null;
                    curr.right = next;
                }
            }
            curr = curr.right;
        }
    }

    /**
     * 和 {@link LeetCode114#flatten_2b(cn.mitrecx.TreeNode)} 相比, 此解法的 predecessor 不是严格的 "curr.left 在先序遍历的最后一个结点",
     * 而是简单的 curr.left 的最右结点.
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void flatten_3b(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
