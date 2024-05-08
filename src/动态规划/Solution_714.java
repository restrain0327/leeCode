package 动态规划;

public class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        // 714 买卖股票的最佳时机含手续费

        int[][] dp = new int[prices.length][2];

        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = Math.max(0, -fee);

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
            System.out.println(dp[i][0] + " " + dp[i][1]);
        }

        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(new Solution_714().maxProfit(prices, 2));
    }
}
