package cn.mitrecx;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class LeetCode82 {

    public static void main(String[] args) {
        ListNode aa = new ListNode(5);
        ListNode bb = new ListNode(4);
        bb.next = aa;
        ListNode cc = new ListNode(4);
        cc.next = bb;
        ListNode dd = new ListNode(3);
        dd.next = cc;
        ListNode e = new ListNode(3);
        e.next = dd;
        ListNode f = new ListNode(2);
        f.next = e;
        ListNode head1 = new ListNode(1);
        head1.next = f;

        LeetCode82 leetCode82 = new LeetCode82();
        leetCode82.deleteDuplicates(head1);
        leetCode82.print(head1);
    }


    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {// 是重复元素, cur 不动, 为 cur.next 找下一个不是重复的元素
                // 记录重复值
                int v = cur.next.val;
                while (cur.next != null && cur.next.val == v) {
                    cur.next = cur.next.next;
                }
            } else { // 不是重复元素, cur 后移一步
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
