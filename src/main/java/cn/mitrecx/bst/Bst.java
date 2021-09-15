package cn.mitrecx.bst;

import java.util.ArrayList;
import java.util.List;

public class Bst {
    public List<Integer> inorderTreeWalk(Node root) {
        List<Integer> result = new ArrayList<>();
        doInorderTreeWalk(root, result);
        return result;
    }

    public void doInorderTreeWalk(Node root, List<Integer> result) {
        if (root != null) {
            doInorderTreeWalk(root.getLeft(), result);
            // System.out.println(root.getKey());
            result.add(root.getKey());
            doInorderTreeWalk(root.getRight(), result);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6, null);
        Node n51 = new Node(5, root);
        root.setLeft(n51);
        Node n52 = new Node(5, n51);
        n51.setRight(n52);
        Node n2 = new Node(2, n51);
        n51.setLeft(n2);
        Node n7 = new Node(7, root);
        root.setRight(n7);
        Node n8 = new Node(8, n7);
        n7.setRight(n8);

        Bst bst = new Bst();
        List<Integer> r = bst.inorderTreeWalk(root);
        r.forEach(i -> System.out.print(i + " "));
    }
}
