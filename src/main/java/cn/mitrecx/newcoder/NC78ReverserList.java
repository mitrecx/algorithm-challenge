package cn.mitrecx.newcoder;

public class NC78ReverserList {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = head;
        ListNode k = h.next;
        while (k != null) {
            ListNode p = k.next;
            k.next = h;
            h = k;
            k = p;
        }
        return h;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        NC78ReverserList nc78ReverserList = new NC78ReverserList();
        ListNode h = nc78ReverserList.ReverseList(head);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
