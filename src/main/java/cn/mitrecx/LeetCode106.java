package cn.mitrecx;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 二叉树, 递归, 双指针/二分
 * @see LeetCode105
 */
public class LeetCode106 {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        LeetCode106 leetCode106 = new LeetCode106();
        TreeNode r = leetCode106.buildTree(inorder, postorder);
        System.out.println(r.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorderMap, 0, inorder.length - 1);
    }

    /**
     * @param postorder  后序遍历序列
     * @param postLeft   后序遍历序列的左边界(inclusive)
     * @param postRight  后序遍历的右边界(inclusive)
     * @param inorderMap 中序遍历序列
     * @param inLeft     中序遍历的左边界(inclusive)
     * @param inRight    中序遍历的右边界(inclusive)
     * @return 由(后序 / 中序)所有结点构成的二叉树
     */
    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, Map<Integer, Integer> inorderMap, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = inorderMap.get(rootVal);
        root.left = buildTree(postorder, postLeft, pIndex + postLeft - inLeft - 1, inorderMap, inLeft, pIndex - 1);
        root.right = buildTree(postorder, pIndex + postLeft - inLeft, postRight - 1, inorderMap, pIndex + 1, inRight);
        return root;
    }

}
