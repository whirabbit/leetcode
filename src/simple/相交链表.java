package simple;

import tools.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author whirabbit
 * @Date 2021/8/12 21:10
 * @Version 1.0
 */
public class 相交链表 {
    /**
     * 集合
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }


    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        ListNode a,b;
        a=headA;

        return  null;
    }

}
