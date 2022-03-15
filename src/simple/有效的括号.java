package simple;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author whirabbit
 * @Date 2021/7/19 21:12
 * @Version 1.0
 */
public class 有效的括号 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //获取开始时间

         //测试的代码段
        System.out.println(new 有效的括号().isValid("{}{}{}{}{}{}{}{}"));

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间


        System.out.println(new 有效的括号().isValid_2("{}"));

    }
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
    public boolean isValid_2(String s){
        int length = s.length();
        if (length%2==1){
            return false;
        }
        Deque<Character> characters=new LinkedList<>();
        Map<Character,Character> pairs=new HashMap<>();
        pairs.put('}','{');
        pairs.put(']','[');
        pairs.put(')','(');

        char c;
        for (int i=0;i<length;i++){
            c=s.charAt(i);
            if (pairs.containsKey(c)){
                if (characters.isEmpty()||characters.peek()!=pairs.get(c)){
                    return  false;
                }
                characters.pop();
            }else {
                characters.push(c);
            }
        }
        return characters.isEmpty();
    }
}
