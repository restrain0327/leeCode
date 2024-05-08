package 动态规划;

import java.util.Arrays;

public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        // 188 买卖股票的最佳时机4
        // 至多买卖k次

        // 其实核心和 3 差不多
        // 第几天
        // 当天第几次买卖
        // 持有和不持有的金额

        //三维数组
//        int[][][] dp = new int[prices.length][k+1][2];
//
//
//        //初始化
//        for (int i = 0; i <= k; i++) {
//            dp[0][i][0] = -prices[0]; //持有
////            dp[0][i][1] = 0; // 第i次不持有当天股票
//        }
//
//        for (int i = 1; i < prices.length; i++) {
//            for (int j = 1; j <= k; j++) {
//                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] - prices[i]); // 持有
//                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] + prices[i]); // 不持有
//            }
////            for (int j = 1; j <= k; j++) {
////                System.out.print(dp[i][j][0] + " ");
////                System.out.print(dp[i][j][1] + " ");
////            }
////            System.out.println();
//        }


//        return dp[prices.length-1][k][1];

        int [][] dp = new int[prices.length][2*k+1];
        // 和 3 一样

        //初始化
        for (int i=1; i<2*k; i+=2){
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j=0; j < 2 * k - 1; j+=2) {
                // 持有
                dp[i][j+1] = Math.max(dp[i-1][j + 1], dp[i-1][j] - prices[i]);
                // 不持有
                dp[i][j+2] = Math.max(dp[i-1][j + 2], dp[i-1][j+1] + prices[i]);
            }
        }

        return dp[prices.length-1][2*k];
    }

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(new Solution_188().maxProfit(2, prices));
    }
}
