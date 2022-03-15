package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * @Author whirabbit
 * @Date 2021/7/12 20:20
 * @Version 1.0
 */
public class 字符串转换整形 {
    /**
     * 失败
     */
    public static void main(String[] args) {
        String s = "000000147";
        char[] chars = s.toCharArray();
        boolean zheng = true;
        boolean isNum = false;
        char[] res = new char[11];
        res[0] = '0';
        int flag = 0;
        int sign=0;
        for (char c : chars) {
            if (sign>1){
                break;
            }
            if (c == ' ') {
                continue;
            }
            if (!isNum && c == '-') {
                zheng = false;
                sign++;
                continue;
            }
            if (!isNum && c == '+') {
                zheng = true;
                sign++;
                continue;
            }

            if (c != ' ' && !isNum && (c > '9' || c < '0')) {
                break;
            }
            if (!isNum&&c <= '9' && c >='0') {
                isNum = true;
            }
            if (isNum) {
                if (c=='0'&&flag==0){
                    continue;
                }
                res[flag] = c;
                flag++;

                if (flag >= 11) {
                    break;
                }

            }

        }
        Integer value = 0;
        try {
            StringBuffer buffer = new StringBuffer(String.valueOf(res));
            for (int i = 0; i < 11; i++) {

                if (buffer.charAt(i) < '0' || buffer.charAt(i) > '9') {
                    buffer.setLength(i);
                    break;
                }
            }
            value = Integer.parseInt(buffer.toString());
            if (!zheng) {
                value = -value;
            }
        } catch (Exception e) {
            if (zheng) {
                value = Integer.MAX_VALUE;
            } else {
                value = Integer.MIN_VALUE;
            }

        }
        System.out.println("value=" + value);
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

}
