package 剑指Offer.day8;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * @author wrobby
 * @version 1.0
 * @date 2022/3/21 21:43
 */
public class 股票的最大利润 {
    class Solution {
        public int maxProfit(int[] prices) {
            //记录历史最低价格
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }

        public int maxProfit_2(int[] prices) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            return max - min;
        }
    }
}
