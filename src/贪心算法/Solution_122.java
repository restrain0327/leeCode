package 贪心算法;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        //买卖股票的最佳时机||
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            //贪心算法
            //大于马上卖掉 在买入
            res += Math.max(prices[i] - prices[i-1], 0);
        }

        return res;
    }
}
