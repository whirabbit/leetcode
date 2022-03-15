package tools;

/**
 * 单链表
 * @Author whirabbit
 * @Date 2021/7/29 20:37
 * @Version 1.0
 */
  public class ListNode {
   public int val;
   public ListNode next;

   public ListNode() {
//       next=null;
    }

   public ListNode(int val) {
        this.val = val;
    }

   public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        System.out.println(node.next);
    }
}
