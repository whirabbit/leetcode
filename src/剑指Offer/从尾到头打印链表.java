package 剑指Offer;

import tools.ListNode;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/15 22:44
 */
public class 从尾到头打印链表 {
    static class Solution {
        /**
         * 先反转再遍历
         * @param head
         * @return
         */
        public static int[] reversePrint(ListNode head) {
            ListNode no = new ListNode();
            int sum = 0;
            while (head != null) {
                sum++;
                ListNode temp = head;
                head = head.next;
                temp.next = no.next;
                no.next = temp;
            }

            int[] array = new int[sum];
            for (int i = 0; i < sum; i++) {
                array[i] = no.next.val;
                no = no.next;
            }
            return array;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.reversePrint(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))))));
    }
}
