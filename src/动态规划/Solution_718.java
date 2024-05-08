package 动态规划;

public class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        // 最长重复子数组

        // dp数组含义 i-1下标的nums1和j-1下标的nums2最长重复子数组
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        // 初始化 [i-1][0] [0][j-1]都没意义
        //全部为0

        int res = 0;

        for (int i=1; i<=nums1.length; i++){
            for (int j=1; j<= nums2.length; j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
