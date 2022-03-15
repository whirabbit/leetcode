package simple;

import tools.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 *
 * @Author whirabbit
 * @Date 2021/7/29 19:37
 * @Version 1.0
 */
public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        int tmp_val = head.val;
        ListNode node = head;
        ListNode tmp_node = node.next;
        while (tmp_node != null) {
            if (tmp_node.val == tmp_val) {
                node.next = tmp_node.next;
                tmp_node = node.next;
            } else {
                node = node.next;
                tmp_val = node.val;
                tmp_node = tmp_node.next;
            }
        }
        return head;
    }
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
