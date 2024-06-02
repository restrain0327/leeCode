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
//                System.out.println("s:" + s.charAt(i-1) + " t:" + t.charAt(j-1) + "  dp:" + dp[i][j] +" i:" +  i + " j:" + j);
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new Solution_115().numDistinct(s, t));
        // 就是0:i-1 区间中有多少个0:j-1
        /**
         * s:r t:r  dp:1 i:1 j:1
         * s:r t:a  dp:0 i:1 j:2
         * s:r t:b  dp:0 i:1 j:3
         * s:r t:b  dp:0 i:1 j:4
         * s:r t:i  dp:0 i:1 j:5
         * s:r t:t  dp:0 i:1 j:6
         * s:a t:r  dp:1 i:2 j:1
         * s:a t:a  dp:1 i:2 j:2
         * s:a t:b  dp:0 i:2 j:3
         * s:a t:b  dp:0 i:2 j:4
         * s:a t:i  dp:0 i:2 j:5
         * s:a t:t  dp:0 i:2 j:6
         * s:b t:r  dp:1 i:3 j:1
         * s:b t:a  dp:1 i:3 j:2
         * s:b t:b  dp:1 i:3 j:3
         * s:b t:b  dp:0 i:3 j:4
         * s:b t:i  dp:0 i:3 j:5
         * s:b t:t  dp:0 i:3 j:6
         * s:b t:r  dp:1 i:4 j:1
         * s:b t:a  dp:1 i:4 j:2
         * s:b t:b  dp:2 i:4 j:3
         * s:b t:b  dp:1 i:4 j:4
         * s:b t:i  dp:0 i:4 j:5
         * s:b t:t  dp:0 i:4 j:6
         * s:b t:r  dp:1 i:5 j:1
         * s:b t:a  dp:1 i:5 j:2
         * s:b t:b  dp:3 i:5 j:3
         * s:b t:b  dp:3 i:5 j:4
         * s:b t:i  dp:0 i:5 j:5
         * s:b t:t  dp:0 i:5 j:6
         * s:i t:r  dp:1 i:6 j:1
         * s:i t:a  dp:1 i:6 j:2
         * s:i t:b  dp:3 i:6 j:3
         * s:i t:b  dp:3 i:6 j:4
         * s:i t:i  dp:3 i:6 j:5
         * s:i t:t  dp:0 i:6 j:6
         * s:t t:r  dp:1 i:7 j:1
         * s:t t:a  dp:1 i:7 j:2
         * s:t t:b  dp:3 i:7 j:3
         * s:t t:b  dp:3 i:7 j:4
         * s:t t:i  dp:3 i:7 j:5
         * s:t t:t  dp:3 i:7 j:6
         */
    }
}
