package medium;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * q      w
 * q    w
 * q w
 * q
 *
 * @Author whirabbit
 * @Date 2021/8/25 15:10
 * @Version 1.0
 */
public class Z字形变换 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();

        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                builder.append(s.charAt(j + i));
                //除了第一排和最后一排,其他一个循环有两个
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    builder.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
