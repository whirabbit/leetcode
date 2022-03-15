package medium;

import tools.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @Author wrobby
 * @Date 2021/10/7 21:45
 * @Version 1.0
 */
public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = head;
        ListNode f = null, p = head, q = head;
        for (int i = 0; i < n-1; i++) {
            q = q.next;
        }
        while (q.next != null) {
            f = p;
            p = p.next;
            q = q.next;
        }
        if (p.equals(head)) {
            headNode = headNode.next;
        } else {
            f.next = p.next;
        }
        return headNode;
    }
}
