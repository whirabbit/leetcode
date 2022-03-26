package 剑指Offer.day10;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/23 18:51
 */
public class 把数字翻译成字符串 {
    static class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int n = s.length();
            if (n < 1) {
                return n;
            }
            int a = 1, b = 1;
            int t = 0;
            for (int i = 0; i < n - 1; i++) {
                t = a;
                //01 不能 翻译为b
                if (s.charAt(i) == '0') {
                    b = t;
                    continue;
                }
                int parseInt = Integer.parseInt(s.substring(i, i + 2));
                if (parseInt <= 25) {
                    a = a + b;
                }
                b = t;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
    }
}
