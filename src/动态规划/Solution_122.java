package 动态规划;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        // 122 买卖股票的最佳时机2
        // 可以多次买卖

        // dp数组含义
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[prices.length+1][2];

        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        // 递归
        for (int i=1; i<prices.length; i++){
            //和单次买卖最大区别
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);

            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }


        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution_122().maxProfit(prices));
    }
}
