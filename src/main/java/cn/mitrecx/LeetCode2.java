package cn.mitrecx;

public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = 0, num2 = 0, sum = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;

            result.val = sum;

            if (l1 != null || l2 != null) {
                result.next = new ListNode(carry);
                result = result.next;
            }

        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode h1 = l1;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode h2 = l2;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);

        LeetCode2 leetCode2 = new LeetCode2();
        ListNode r = leetCode2.addTwoNumbers(h1, h2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }
}
