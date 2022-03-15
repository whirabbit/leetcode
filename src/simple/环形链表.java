package simple;

import tools.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @Author whirabbit
 * @Date 2021/8/2 20:53
 * @Version 1.0
 */
public class 环形链表 {
    public static void main(String[] args) {
        int d=3_100;


    }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            if (!set.add(head.next)) {
                // 当前元已经存在于 set，即当前元素第二次出现，有圈
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 尝试同或运算失败
     * @param head
     * @return
     */
    public boolean hasCycle_2(ListNode head) {
        if (head == null) {
            return false;
        }
        int re = head.val;
        while (head.next != null) {
            re = ~(head.next.val ^ re);
            if (re == head.next.val) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public boolean hasCycle_3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
