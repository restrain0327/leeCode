package 动态规划;

public class Solution_509 {
    public int fib(int n) {
        // 动态规划五部曲

        // dp数组以及下标
        // 递推公式
        // dp数组如何初始化
        // 遍历顺序
        // 打印dp数组

        if (n<=1){
            return n;
        }

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
