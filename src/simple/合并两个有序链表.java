package simple;

import tools.ListNode;

/**
 * @Author whirabbit
 * @Date 2021/7/25 19:28
 * @Version 1.0
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode flag = node;
        while (l1 != null && l2 != null){
        if (l1.val< l2.val){
            node.next=l1;//未置空l1
            l1=l1.next;
        }else {
            node.next=l2;//未置空l2
            l2=l2.next;
        }
        node=node.next;
        }
        if (l1!=null){
            node.next=l1;
            l1=l1.next;
        }else if (l2!=null){
            node.next=l2;
            l1=l2.next;
        }
        return  flag.next;
    }
}
