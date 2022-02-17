package cn.mitrecx;

/**
 * 86. Partition List
 * medium
 * kw: 链表
 */
public class LeetCode86 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(1);
        l6.next = l5;
        l5.next = l4;
        l4.next = l3;
        l3.next = l2;
        l2.next = l1;

        ListNode.print(l6);
        LeetCode86 leetCode86 = new LeetCode86();
        ListNode head = leetCode86.partition(l6, 3);
        ListNode.print(head);

        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(5);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(3);
        ListNode ln5 = new ListNode(4);
        ListNode ln6 = new ListNode(1);
        ln6.next = ln5;
        ln5.next = ln4;
        ln4.next = ln3;
        ln3.next = ln2;
        ln2.next = ln1;
        ListNode.print(ln6);
        ListNode head2 = leetCode86.partition(ln6, 3);
        ListNode.print(head2);
    }


    // 正常思路: 模拟
    // 用一个遍历指针, 再用一个指示边界的指针
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode low = dummy;
        ListNode p = dummy;
        // 初始移动: p.next 大于等于 x, 防止 p.next 是 head, 从而避免 造成移动结点时 dummy.next 丢结点
        while (p.next != null && p.next.val < x) {
            p = p.next;
            low = low.next;
        }
        while (p.next != null) {
            if (p.next.val < x) {
                ListNode curr = p.next;
                p.next = curr.next;
                curr.next = low.next;
                low.next = curr;
                low = low.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    // 更简单的方法: 用两个链表, 一个放小于x的node, 另一个放大于x的node, 最后合二为一
    public ListNode partition_2(ListNode head, int x) {
        ListNode low = new ListNode();
        ListNode lowHead = low;
        ListNode high = new ListNode();
        ListNode highHead = high;
        while (head != null) {
            if (head.val < x) {
                low.next = head;
                low = low.next;
            } else {
                high.next = head;
                high = high.next;
            }
            head = head.next;
        }
        high.next = null;
        low.next = highHead.next;
        return lowHead.next;
    }
}
