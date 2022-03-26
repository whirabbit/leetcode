package 剑指Offer.day11;

import tools.ListNode;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/25 17:35
 */
public class 链表中倒数第k个节点 {
    static class Solution {
        ListNode node;

        /**
         * 递归
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            get(head, k);
            if (node == null) {
                return head;
            }
            return node;
        }

        private int get(ListNode node, int k) {
            if (node == null) {
                return 0;
            } else {
                int i = get(node.next, k);
                if (k == i) {
                    this.node = node.next;
                }
                return i + 1;
            }
        }

        /**
         * 双指针
         */

        public ListNode getKthFromEnd_2(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && k > 0) {
                fast = fast.next;
                k--;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getKthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 2).val);
    }
}
