package medium;

/**
 * 数字转罗马数字
 * @Author wrobby
 * @Date 2021/9/20 10:25
 * @Version 1.0
 */
public class 整数转罗马数字 {
    /**
     * 砝码
     */
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] Roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                num -= values[i];
                builder.append(Roman[i]);
            } else {
                i++;
            }
        }
        return builder.toString();
    }
}
