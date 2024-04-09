package 动态规划;

public class Solution_70 {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}
