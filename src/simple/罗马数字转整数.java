package simple;

/**
 *
 * @Author whirabbit
 * @Date 2021/7/13 20:40
 * @Version 1.0
 */
public class 罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(new 罗马数字转整数().romanToInt("VII"));
    }
        public int romanToInt(String s) {
            s = s.replace("IV","a");
            s = s.replace("IX","b");
            s = s.replace("XL","c");
            s = s.replace("XC","d");
            s = s.replace("CD","e");
            s = s.replace("CM","f");

            int result = 0;
            for (int i=0; i<s.length(); i++) {
                result += which(s.charAt(i));
            }
            return result;
        }

        public int which(char ch) {
            switch(ch) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                case 'a': return 4;
                case 'b': return 9;
                case 'c': return 40;
                case 'd': return 90;
                case 'e': return 400;
                case 'f': return 900;
            }
            return 0;
        }

}
