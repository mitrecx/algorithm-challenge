package cn.mitrecx.leetcode1_200;

import cn.mitrecx.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * Medium
 * <p>
 * 影_
 * 二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，
 * 小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
 */
public class LeetCode95 {
    public static void main(String[] args) {
        LeetCode95 lc = new LeetCode95();
        List<TreeNode> list = lc.generateTrees(2);
        System.out.println(list);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 0)
            return null;
        return generateTrees(1, n);
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private List<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> allTrees = new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合, currRoot根节点的值大于左子树所有节点的值
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合, currRoot根节点的值小于右子树所有节点的值
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    //
                    TreeNode currRoot = new TreeNode(i);
                    currRoot.left = left;
                    currRoot.right = right;
                    allTrees.add(currRoot);
                }
            }
        }
        return allTrees;
    }
}
