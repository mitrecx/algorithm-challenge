package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 99. Recover Binary Search Tree
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 二叉搜索树 binary search tree (BST)
 */
public class LeetCode99 {
    public static void main(String[] args) {

    }

    /**
     * 先找到调换位置的两个结点, 然后把这两个结点调换
     */
    public void recoverTree(TreeNode root) {
        // 通过中序遍历找到被调换的两个结点值
        List<Integer> it = inorderTraversal(root);
        int[] swapped = getSwappedValues(it);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void recover(TreeNode root, int count, int v1, int v2) {
        if (root != null) {
            if (root.val == v1 || root.val == v2) {
                // 调换两个数, 不能重复
                root.val = root.val == v1 ? v2 : v1;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left, count, v1, v2);
            recover(root.right, count, v1, v2);
        }
    }

    public int[] getSwappedValues(List<Integer> list) {
        // 有序数组中 有且仅有 两个数调换了位置, 如何找到这两个数?
        // 有两种可能:
        // 1. 相邻的两个数
        // 2. 不相邻的两个数(相邻元素对比时, 会出现两个逆序, 第一个取前一个数, 第二个取后一个)
        int index1 = -1, index2 = -1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                index2 = i;
                if (index1 == -1) {
                    index1 = i - 1;
                }
            }
        }
        return new int[]{list.get(index1), list.get(index2)};
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 非递归实现BST中序遍历
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * 解法2, 利用非递推中序遍历的特性:
     * 正常的 BST 中序遍历时, stack 先 pop 的元素总是小于 后 pop 的元素
     */
    public void recoverTree_2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode tn1 = null, tn2 = null;
        // stack 中上一个 pop 的元素. N.B., 正常的 BST 中序遍历时, stack 先 pop 的元素总是小于后pop的元素的
        TreeNode prevPop = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prevPop != null && prevPop.val > root.val) {
                tn2 = root;
                if (tn1 == null) {
                    tn1 = prevPop;
                } else {
                    break;
                }
            }
            prevPop = root;
            root = root.right;
        }
        // swap
        int temp = tn1.val;
        tn1.val = tn2.val;
        tn2.val = temp;
    }
}
