package 剑指Offer.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wrobby
 * @version 1.0
 * @date 2022/3/26 11:40
 */
public class 翻转单词顺序 {
    static class Solution {
        public String Solution(){
            return "r23";
        }
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

    static Integer test() {
        try {
            Integer[] a = {1, 2, 3};
            List<Integer> list = Arrays.asList(a);
            list.add(4);
            System.out.println(0);
            return 0;
        } catch (Exception e) {
            System.out.println(1);
        } finally {
            System.out.println(2);
            return 2;
        }
    }
public<T> List<T> test(Class<T> a){
        return new ArrayList<>();
}
    private static int i = 0;

    public static void main(String[] args) {
        System.out.println(new Solution());

    }

}
