package 剑指Offer;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
 * 在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/14 22:00
 */
public class 包含min函数的栈 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> pr = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            pr.add(x);
            stack.push(x);
        }

        public void pop() {
            pr.remove(stack.pop());
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return pr.peek();
        }
    }
}
