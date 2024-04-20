package 动态规划;

public class Solution_213 {
    public int rob(int[] nums) {
        // 213 打家劫舍||
        // 环形抢劫 抢了头就不能抢尾 抢了尾就不能抢头
        if (nums.length == 1){
            return nums[0];
        }

        // 防止下面数组越界
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // nums有三个以上元素
        //抢头不抢尾
        int res1 = robAction(nums, 0, nums.length-1);

        //抢尾不抢头
        int res2 = robAction(nums, 1, nums.length);

        return Math.max(res1, res2);
    }

    public int robAction(int[] nums, int first, int last){
        //对给定范围进行抢劫
        // 左闭右开区间

        int[] dp = new int[nums.length+1];
        dp[first] = nums[first];
        dp[first+1] = Math.max(dp[first], nums[first+1]);

        for (int i=first+2; i<last; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[last-1];
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(new Solution_213().rob(nums));
    }
}
