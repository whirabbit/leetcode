package 剑指Offer.day8;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/21 21:32
 */
public class 青蛙跳台阶问题 {
    class Solution {
        /**
         * 思路与斐波那契数列相同
         */
        public int numWays(int n) {
            if (n < 2) {
                return 1;
            } else {
                int a = 1;
                int b = 1;
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
