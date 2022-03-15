package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * @Author wrobby
 * @Date 2021/10/27 22:16
 * @Version 1.0
 */
public class 删除无效的括号 {
    public List<String> removeInvalidParentheses(String s) {
        //结果
        List<String> list = new ArrayList<>(s.length());
        //set,保存下次遍历元素
        Set<String> a = new HashSet<>();
        a.add(s);
        while (true) {
            a.forEach(str -> {
                if (check(str)) {
                    list.add(str);
                }
            });
            if (list.size() > 0) {
                return list;
            }
            Set<String> b = new HashSet<>();
            a.forEach(str -> {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        b.add(str.substring(0, i) + str.substring(i + 1));
                    }

                }
            });
            a = b;
        }

    }


    private boolean check(String str) {
        StringBuilder builder = new StringBuilder(str);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = builder.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
            return count == 0;
        }

        public static void main (String[]args){
            String s = "hifubqawioufbuoqwb";

            long l1 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                for (int i1 = 0; i1 < s.length(); i1++) {
                    boolean b = s.charAt(i1) == 's';
                }
            }
            long l2 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    boolean b = c == 'd';
                }
            }
            long l3 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                StringBuilder builder = new StringBuilder(s);
                for (int i1 = 0; i1 < builder.length(); i1++) {
                    boolean b = s.charAt(i1) == 's';
                }
            }
            long l4 = System.currentTimeMillis();
            System.out.println("第一种:" + (l2 - l1));
            System.out.println("第二种:" + (l3 - l2));
            System.out.println("第三种:" + (l4 - l3));
        }
    }
