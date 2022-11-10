package cn.mitrecx;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(String alert, ListNode node) {
        System.out.print("alert: ");
        print(node);
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode construct(Integer... vals) {
        int size = vals.length;
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int i = 0; i < size - 1; i++) {
            curr.val = vals[i];
            curr.next = new ListNode();
            curr = curr.next;
        }
        curr.val = vals[size - 1];

        return head;
    }
}
