package 动态规划;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/8 12:22
 */
public class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        // 392 判断子序列
        // len1 < len2

        int len1 = s.length();
        int len2 = t.length();

        if (len1 > len2){
            return false;
        }

        int[][] dp = new int[len1+1][len2+1];

        // 从一开始不用初始化 后面会覆盖 而且一定要写等于
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
//                System.out.println(dp[i][j]);
            }
        }
//        System.out.println(dp[len1][len2]);
        return dp[len1][len2] == len1;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Solution_392().isSubsequence(s, t));
    }
}
