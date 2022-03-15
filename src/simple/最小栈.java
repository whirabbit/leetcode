package simple;

import tools.ListNode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @Author whirabbit
 * @Date 2021/8/3 22:54
 * @Version 1.0
 */
public class 最小栈 {
    static class MinStack {

        private ListNode head;
        private ListNode min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        //        将元素 x 推入栈中。
        public void push(int val) {
            if (head == null) {
                min = new ListNode(val);
                head = new ListNode(val);
            } else {
                if (val < min.val) {
                    min = new ListNode(val, min);
                } else {
                    min = new ListNode(min.val, min);
                }
                head = new ListNode(val, head);
            }
        }

        //        删除栈顶的元素。
        public void pop() {
            if (head != null&&min!=null) {
                head = head.next;
                min = min.next;
            }

        }

        //        获取栈顶元素。
        public Integer top() {
            if (head == null) {
                return null;
            }
            return head.val;
        }

        //        检索栈中的最小元素。
        public Integer getMin() {
            if (min == null) {
                return null;
            }

            return min.val;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        while (stack.head != null) {
            System.out.println("min:" + stack.min.val);
            System.out.println(stack.top());
            stack.pop();
        }
    }
}
