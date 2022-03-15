package simple;

/**
 * @Author whirabbit
 * @Date 2021/8/15 20:17
 * @Version 1.0
 */
public class 阶乘后的零 {
    /**
     * 5 的个数对应0的个数
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 4) {
            result += n / 5;
            n /= 5;
        }

        return result;
    }
}
