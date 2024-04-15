package 动态规划;

import java.util.Arrays;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        //322 零钱兑换
        // 因为要求最少硬币数量 所以非0都初始化为max
        int max = Integer.MAX_VALUE;

        int[] dp = new int[amount+1];

        Arrays.fill(dp, max);

        // 当背包重量为0时 金额为0
        dp[0] = 0;
        //金币可以重复拿 完全背包
        for (int i=0; i<coins.length; i++){
            for (int j=coins[i]; j <= amount; j++){
                if (dp[j-coins[i]] != max){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }

            for (int i1 : dp) {
                System.out.print(i1+ " ");
            }
            System.out.println();
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution_322 solution322 = new Solution_322();
        int[] coins = {1, 2, 5};
        solution322.coinChange(coins, 11);
    }
}
