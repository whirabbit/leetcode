package simple;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @Author whirabbit
 * @Date 2021/7/31 21:17
 * @Version 1.0
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minprice = prices[0];
        for (int i = 1; i < prices.length; i++)
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        return maxprofit;
    }
}
