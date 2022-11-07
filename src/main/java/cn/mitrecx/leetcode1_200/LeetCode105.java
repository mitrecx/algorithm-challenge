package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 * Self Difficulty: 上
 * kw: 二叉树, 递归, 双指针/二分
 * @see LeetCode106
 */
public class LeetCode105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        LeetCode105 leetCode105 = new LeetCode105();
        TreeNode r = leetCode105.buildTree(preorder, inorder);
        System.out.println(r.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length - 1);
    }

    /**
     * @param preorder   前序遍历序列
     * @param preLeft    前序遍历序列的左边界(inclusive)
     * @param preRight   前序遍历的右边界(inclusive)
     * @param inorderMap 中序遍历序列
     * @param inLeft     中序遍历的左边界(inclusive)
     * @param inRight    中序遍历的右边界(inclusive)
     * @return 由(前序 / 中序)所有结点构成的二叉树
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> inorderMap, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pIndex = inorderMap.get(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, pIndex + preLeft - inLeft, inorderMap, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex + preLeft - inLeft + 1, preRight, inorderMap, pIndex + 1, inRight);
        return root;
    }
}
