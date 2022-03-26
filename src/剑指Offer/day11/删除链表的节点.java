package 剑指Offer.day11;

import tools.ListNode;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/24 22:22
 */
public class 删除链表的节点 {
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            if ((head.val == val)) {
                return head.next;
            }
            ListNode node1, node2;
            node1 = head;
            node2 = node1.next;
            while (node2 != null) {
                if (node2.val == val) {
                    node1.next = node2.next;
                    break;
                }
                node1 = node1.next;
                node2 = node2.next;
            }


            return head;
        }
    }
}
