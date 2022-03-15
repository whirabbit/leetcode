package simple;

/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @Author whirabbit
 * @Date 2021/7/31 22:35
 * @Version 1.0
 */
public class 买卖股票的最佳时机II {
    /**
     * 保证每两天的利润最大,能保证整体利润最大(局部最优 贪心算法)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {

            max += Math.max(0, prices[i] - prices[i - 1]);

        }
        return max;
    }

}
