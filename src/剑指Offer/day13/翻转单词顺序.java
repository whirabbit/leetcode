package 剑指Offer.day13;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/26 11:40
 */
public class 翻转单词顺序 {
    static class Solution {
        public String reverseWords(String s) {
            String[] s1 = s.split(" ");
            int i = s1.length - 1;
            if (i < 0) {
                return "";
            }
            StringBuilder builder = new StringBuilder(s1[i--]);
            for (; i >= 0; i--) {
                if ("".equals(s1[i])) {
                    continue;
                }
                builder.append(" ").append(s1[i]);
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  hello     world!  "));
    }
}
