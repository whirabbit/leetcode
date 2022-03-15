package simple;

/**
 * @Author whirabbit
 * @Date 2021/7/29 19:35
 * @Version 1.0
 */
public class 爬楼梯 {
    /**
     * 动态规划
     * fx=fx-1 + fx-2
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
