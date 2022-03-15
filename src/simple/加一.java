package simple;

import java.util.Arrays;

/**
 * @Author whirabbit
 * @Date 2021/7/28 17:38
 * @Version 1.0
 */
public class 加一 {
    public static void main(String[] args) {
        int[] nums = new int[]{9};
        System.out.println(Arrays.toString(Arrays.copyOf(nums, 4)));
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        int flag;
        int carry = 1;
        for (int i = length; i > -1; i--) {
            flag = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = flag;
            if (carry == 0) {
                break;
            }
            if (i == 0 && carry != 0) {
                int[] ints = new int[length + 2];
                ints[0] = carry;
                for (int j = 1; j < length + 2; j++) {
                    ints[j] = digits[j - 1];
                }
                return ints;
            }
        }

        return digits;
    }
}
