package cn.mitrecx;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 116. Populating Next Right Pointers in Each Node
 * Difficulty: Medium
 * Self Difficulty: 中
 * kw: 层序遍历 {@link LeetCode102}
 */
public class LeetCode116 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        LeetCode116 leetCode116 = new LeetCode116();
        leetCode116.connect(root);
        System.out.println(root.left.next.val); // 3
    }

    /**
     * @see LeetCode102#levelOrder_2b(cn.mitrecx.TreeNode)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 当前层的元素个数
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                Node curr = queue.poll();
                // 处理
                if (i < currentLevelSize - 1) {
                    curr.next = queue.peek();
                }
                // 下一层
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }
}
