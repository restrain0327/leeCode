package 动态规划;

public class Solution_518 {
    public int change(int amount, int[] coins) {
        // 518 零钱兑换||
        // 物品有无限个 完全背包

        int[] dp = new int[amount+1];

        //初始化
        dp[0] = 1;

        for (int i=0; i<coins.length; i++){
            //完全背包要正序遍历
            //背包要大于等于物品的重量
            for (int j=coins[i]; j<=amount; j++){
                //装满背包有多少种方法 用下面的公式
                dp[j] += dp[j - coins[i]];
                System.out.print(dp[j]);
            }
            System.out.println();
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution_518 solution518 = new Solution_518();
        int[] coins = {1, 2, 5};
        System.out.println(solution518.change(5, coins));
    }
}
