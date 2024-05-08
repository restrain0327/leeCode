package 动态规划;/*
 * @author 谢金桐
 * @date 2024/5/6 18:36
 */

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        // 最大子数组和 动态规划
        if (nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];


        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 其实和贪心差不多
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
//            System.out.println(dp[i] + " " + res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(new Solution_53().maxSubArray(nums));
    }
}
