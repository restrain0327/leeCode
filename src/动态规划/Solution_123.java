package 动态规划;

import java.util.Arrays;

public class Solution_123 {
    public int maxProfit(int[] prices) {
        // 123 买卖股票的最佳时机3
        // 至多买卖两次

        // 第二次购买依赖于第一次购买

        int[][] dp = new int[prices.length][5];

        //初始化
        dp[0][0] = 0; // 不操作 可以不定义
        dp[0][1] = -prices[0]; // 第一次持有股票
        dp[0][2] = 0; // 第一次不持有股票
        dp[0][3] = -prices[0]; // 第二次持有股票
        dp[0][4] = 0; //第二次不持有股票

        for (int i=1; i<prices.length; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[prices.length-1][4];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(new Solution_123().maxProfit(prices));
    }
}
