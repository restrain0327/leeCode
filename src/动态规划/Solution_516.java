package 动态规划;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/14 12:22
 */
public class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        // 516 最长回文子序列
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        
    }
}
