package cn.mitrecx;

public class LeetCode21 {

    public static void main(String[] args) {
        LeetCode21 leetCode21 = new LeetCode21();
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        b.next = a;
        ListNode list1 = new ListNode(1);
        list1.next = b;
        leetCode21.print(list1);

        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);
        d.next = c;
        ListNode list2 = new ListNode(1);
        list2.next = d;
        leetCode21.print(list2);

        ListNode r = leetCode21.mergeTwoLists(list1, list2);
        leetCode21.print(r);

    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode r = new ListNode();
        ListNode head = r;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                r.next = list1;
                r = r.next;
                list1 = list1.next;
            } else {
                r.next = list2;
                r = r.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            r.next = list1;
        }
        if (list2 != null) {
            r.next = list2;
        }
        return head.next;
    }

}
