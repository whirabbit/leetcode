package medium;

import tools.ListNode;

import javax.xml.transform.Result;

/**
 * @Author whirabbit
 * @Date 2021/8/22 9:31
 * @Version 1.0
 */
public class 两数相加 {
    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        int carry = 0;
        int tmp = 0;
        ListNode head = new ListNode();
        ListNode node = head;
        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + carry;
            carry = tmp / 10;
            node.next = new ListNode(tmp % 10);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            tmp = l1.val + carry;
            carry = tmp / 10;
            node.next = new ListNode(tmp % 10);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tmp = l2.val + carry;
            carry = tmp / 10;
            node.next = new ListNode(tmp % 10);
            node = node.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return head.next;
    }

    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        int carry = 0;
        int tmp = 0;
        ListNode result_1 = l1, result_2 = l2, flag = null;
        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + carry;
            carry = tmp / 10;
            l1.val = l2.val = tmp % 10;
            flag = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            isNULL(l1, carry);
            return result_1;
        } else if (l2 != null) {
            isNULL(l2, carry);
            return result_2;
        } else {
            if (carry != 0)
                flag.next = new ListNode(carry);
            return result_1;
        }


    }

    private static void isNULL(ListNode l, int c) {

        int tmp;
        while (l != null) {
            tmp = l.val + c;
            c = tmp / 10;
            l.val = tmp % 10;
            if (l.next == null) {
                if (c!=0)
                l.next = new ListNode(c);
                return;
            }
            l = l.next;

        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(4)));
        ListNode node = addTwoNumbers_2(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
