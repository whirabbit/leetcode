package 剑指Offer.day12;

import tools.ListNode;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/26 11:16
 */
public class 两个链表的第一个公共节点 {
    public class Solution {
        /**
         * n+m=m+n 遇到的第一个就是它们的第一个公共节点。
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                p1 = p1 == null ? headB : p1.next;
                p2 = p2 == null ? headA : p2.next;
            }
            return p1;
        }
    }
}
