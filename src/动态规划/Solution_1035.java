package 动态规划;/*
 * @author 谢金桐
 * @date 2024/5/5 11:00
 */

public class Solution_1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 1035 不想交的线
        // 其实和求最大公共子序列一样

        int[][] dp = new int[nums1.length+1][nums2.length+1];

        // 记得等于
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                // 是i-1 和 j-1
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
