package 动态规划;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/8 12:34
 */
public class Solution_115 {
    public int numDistinct(String s, String t) {
        // 115 不同的子序列
        int [][] dp = new int[s.length()+1][t.length()+1];

        // 递推公式 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        // 初始化
        for (int i = 0; i < s.length()+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    //不等于就拿它的上一个值
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
