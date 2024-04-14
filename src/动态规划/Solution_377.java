package 动态规划;

public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        //排列 完全背包
        int[] dp = new int[target+1];

        //初始化
        dp[0] = 1;

        //排序要先遍历背包 后遍历物品
        for (int i=0; i<=target; i++){
            for (int j=0; j<nums.length; j++){
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }

            for (int i1 : dp) {
                System.out.print(i1+" ");
            }
            System.out.println();
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution_377 solution377 = new Solution_377();
        solution377.combinationSum4(new int[]{1,2,3}, 4);
    }
}
