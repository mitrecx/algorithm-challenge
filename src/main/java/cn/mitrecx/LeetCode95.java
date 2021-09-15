package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public List<TreeNode> generateTrees(int n) {
    if (n < 0)
        return null;
    return generateTrees(1, n);
}

private List<TreeNode> generateTrees(int begin, int end) {
    ArrayList<TreeNode> results = new ArrayList<TreeNode>();
    if (begin > end) {
        results.add(null);
        return results;
    }

    for (int i = begin; i <= end; i++) {
        List<TreeNode> left = generateTrees(begin, i - 1);
        List<TreeNode> right = generateTrees(i + 1, end);
        for (TreeNode leftNode : left) {
            for (TreeNode rightNode : right) {
                TreeNode root = new TreeNode(i);
                root.left = leftNode;
                root.right = rightNode;
                results.add(root);
            }
        }
    }
    return results;
}

    public static void main(String[] args) {
        LeetCode95 lc = new LeetCode95();
        List<TreeNode> list = lc.generateTrees(3);
        System.out.println(list);
    }
}
