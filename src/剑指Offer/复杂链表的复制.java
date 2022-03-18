package 剑指Offer;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/15 22:59
 */
public class 复杂链表的复制 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        /**
         * 在源节点的后面复制节点,再进行分离
         *
         * @param head
         * @return
         */
        public static Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            // 完成链表节点的复制
            Node cur = head;
            while (cur != null) {
                Node copyNode = new Node(cur.val);
                copyNode.next = cur.next;
                cur.next = copyNode;
                cur = cur.next.next;
            }

            // 完成链表复制节点的随机指针复制
            cur = head;
            while (cur != null) {
                if (cur.random != null) { // 注意判断原来的节点有没有random指针
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            // 将链表一分为二
            Node copyHead = head.next;
            cur = head;
            Node curCopy = head.next;
            while (cur != null) {
                cur.next = cur.next.next;
                cur = cur.next;
                if (curCopy.next != null) {
                    curCopy.next = curCopy.next.next;
                    curCopy = curCopy.next;
                }
            }
            return copyHead;
        }
    }

    public static void main(String[] args) {
//        Node l = new Node(3);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        node1.random = l;
//        l.next = node1;
//        node1.next = node2;
//
//        Solution.copyRandomList(l);
    }
}
