package 剑指Offer.day1;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/14 21:38
 */
public class 用两个栈实现队列 {

    class CQueue {
        Stack<Integer> l1 = new Stack<>();
        Stack<Integer> l2 = new Stack<>();

        public CQueue() {

        }

        /**
         * 队列尾部插入整数
         *
         * @param value
         */
        public void appendTail(int value) {
            l1.push(value);
        }

        /**
         * 队列头部删除整数
         *
         * @return
         */
        public int deleteHead() {
            if (l1.empty() && l2.empty()) {
                return -1;
            } else if (l2.empty()) {
                while (!l1.empty()) {
                    l2.push(l1.pop());
                }
            }
            return l2.pop();
        }
    }

}
