package 剑指Offer.day8;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/21 21:12
 */
public class 斐波那契数列 {
    class Solution {
        /**
         * 将递归问题转为非递归
         *
         * @param n
         * @return
         */
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                int a = 1;
                int b = 0;
                int t = a;
                for (int i = 1; i < n; i++) {
                    t = a;
                    a = a + b;
                    b = t;
                    if (a >= 1000000007) {
                        a -= 1000000007;
                    }
                }
                return a;
            }
        }
    }
}
