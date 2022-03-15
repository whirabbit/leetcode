package simple;

import java.util.Calendar;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * @Author whirabbit
 * @Date 2021/7/28 20:04
 * @Version 1.0
 */
public class 二进制求和 {
  static   StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }

    public static String addBinary(String a, String b) {
        char[] a_c = a.toCharArray();
        char[] b_c = b.toCharArray();
        int a_length = a_c.length-1;
        int b_length = b_c.length-1;
        int carry = 0;
        while (a_length >= 0 && b_length >= 0) {
            carry = add(a_c[a_length], b_c[b_length], carry);
            a_length--;
            b_length--;
        }
        if (a_length < 0) {
            while (b_length >= 0) {
                carry = add('0', b_c[b_length], carry);
                b_length--;
            }
        } else {
            while (a_length >=0) {
                carry = add(a_c[a_length], '0', carry);
                a_length--;
            }
        }
        if (carry==1){
            builder.insert(0,carry);
        }
        return builder.toString();
    }

    public static int add(char a, char b, int carry) {
        int tmp = ((a - '0') + (b - '0') + carry) % 2;
        int ca = ((a - '0') + (b - '0') + carry) / 2;
        builder.insert(0, tmp);
        return ca;
    }

}
