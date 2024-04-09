package 动态规划;

import java.util.Arrays;

public class Solution_416 {
    public boolean canPartition(int[] nums) {
        // 可以抽象为背包问题

        //目标值
        int target = 0;
        for (int num : nums) {
            target += num;
        }

        if (target % 2 == 1){
            return false;
        }

        target = target / 2;


        // dp数组
        int[] dp = new int[target+1];

        // 确定递推公式
        // dp[j] = math.Max(dp[j], dp[j - nums[i]] + nums[i]);

        // dp数组初始化
        Arrays.fill(dp, 0);

        //递推 物品 背包
        for (int num : nums) {
            //用一维递推写背包问题 j要倒叙
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }

            //剪枝操作
            if (dp[target] == target){
                return true;
            }
        }

        return dp[target] == target;
    }

}
