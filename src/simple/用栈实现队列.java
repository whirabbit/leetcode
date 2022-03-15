package simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操
 * 作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * @Author wrobby
 * @Date 2021/10/29 21:00
 * @Version 1.0
 */
public class 用栈实现队列 {

    class MyQueue {
        public Deque<Integer> in = new LinkedList<>();
        public Deque<Integer> out = new LinkedList<>();

        public MyQueue() {
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
