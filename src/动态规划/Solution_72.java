package 动态规划;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/11 23:02
 */
public class Solution_72 {
    public int minDistance(String word1, String word2) {
        // 72 编辑距离
        int [][] dp = new int[word1.length()+1][word2.length()+1];

        // 初始化
        for (int i = 0; i <= word1.length(); i++) {
            // 这里 j 是空字符串 所以i有多少个就要执行多少次删除操作
            dp[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        // dp[i][j] 指的是 到i-1和j-1
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i-1][j-1] + 1));
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
