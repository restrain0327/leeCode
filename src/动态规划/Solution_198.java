package 动态规划;

public class Solution_198 {
    public int rob(int[] nums) {
        //198 打家劫舍
        //不能偷相邻的
        if (nums.length == 1)
            return nums[0];


        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] += dp[i-2] + nums[i];
        }

        for (int i : dp) {
            System.out.println(i);
        }

        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
}
