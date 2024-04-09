package 动态规划;

public class Solution_96 {
    public int numTrees(int n){
        // dp的含义: n个节点有多少条路径
        int[] dp = new int[n+1];

        // dp初始化
        dp[0] = 1;
        dp[1] = 1;

        // 递归公式
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
