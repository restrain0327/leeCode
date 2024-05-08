package 动态规划;

import java.util.Arrays;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        // 最长递增子序列

        int[] dp = new int[nums.length];

        // 初始化
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i=0; i< nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
