package simple;

import tools.ListNode;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wrobby
 * @Date 2021/10/20 22:33
 * @Version 1.0
 */
public class 回文链表 {


    public static boolean isPalindrome(ListNode head) {

        ListNode p = head;
        List<ListNode> list = new ArrayList<>(32);
        while (p != null) {

            list.add(p);

            p = p.next;
        }
        int length = list.size();

        int mid = length / 2;
        int l = 0, r = length - 1;
        while (r >= mid) {
            if (!(list.get(l).val == list.get(r).val)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome_2(ListNode head) {
        ListNode p = head, q = head, t_1 = head, t_2 = null;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        int mid = length / 2;
        if (length == 1) {
            return true;
        }
        else if (length==2){
            return head.val==head.next.val;
        }else if (length%2==1){
            mid++;
        }

        p = head;
        for (int i = 0; i <mid; i++) {
            t_1 = t_1.next;
            if (i < mid - 1) {
                q = q.next;
            }
        }
            t_2 = t_1.next;
        while (t_2 != null) {
            t_1.next = t_2.next;
            t_2.next = q.next;
            q.next = t_2;
            t_2 = t_1.next;
        }
        q = q.next;
        while (q != null) {
            if (p.val != q.val) {
                return false;
            }
            q = q.next;
            p = p.next;
        }
        return true;
    }

    public static void main(String[] args) {
      //  System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome_2(new ListNode(1, new ListNode(2,new ListNode(1)))));

    }
}
