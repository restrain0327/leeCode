package 动态规划;

public class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        // 494 目标和

        //target = left - right  => right = left - target
        //sum = left + right
        //left = (sum + target) /2

        //只要求 相加为 left的值有多少就行了

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //如果target的绝对值大于sum，那么是没有方案的
        if (Math.abs(target) > sum) return 0;
        //如果(target+sum)除以2的余数不为0，也是没有方案的
        if ((target + sum) % 2 == 1) return 0;

        int left = (sum + target)/2;

        //dp数组含义: 装满dp[j]有多少种方法
        int[] dp = new int[left+1];

        //初始化
        dp[0] = 1;

        for (int i=0; i< nums.length; i++){
            for (int j=left; j>=nums[i]; j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
            for (int i1 : dp) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }

        return dp[left];
    }

    public static void main(String[] args) {
        Solution_494 solution494 = new Solution_494();
        int[] num = {1,1,1,1,1};
        System.out.println(solution494.findTargetSumWays(num, 3));
    }
}
