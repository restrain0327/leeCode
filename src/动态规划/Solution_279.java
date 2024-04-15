package 动态规划;

import java.util.Arrays;

public class Solution_279 {
    public int numSquares(int n) {
        //279 完全平方数
        //先得到物品
        int num = 0;//物品
        for (num = 0; num < Integer.MAX_VALUE; num++) {
            if (num*num > n){
                break;
            }
        }

        //五部曲
        int[] dp = new int[n+1];

        //非0初始化为max
        Arrays.fill(dp, Integer.MAX_VALUE);
        //背包为0时为0 1为1
        dp[0] = 0;
    
        //完全背包
        for (int i=0; i<num; i++){
            for (int j=i*i; j<=n; j++){
                if (dp[j-i*i] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j - i*i]+1, dp[j]);
            }

            for (int i1 : dp) {
                System.out.print(i1+" ");
            }
            System.out.println();
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_279().numSquares(12));
    }
}
