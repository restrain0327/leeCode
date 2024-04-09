package 动态规划;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class Solution_1049 {
    public int lastStoneWeightII(int[] stones) {
        // 最后一块石头的重量||
        //可以抽象为01背包问题

        int target = 0;
        for (int k : stones) {
            target += k;
        }
        int sum = target;
         
        target = target/2;

        //dp
        int[] dp = new int[target+1];

        Arrays.fill(dp, 0);

        //递归
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
            System.out.println(dp[target]);
        }

        return sum - 2*dp[target];
    }

    public static void main(String[] args) {
        Solution_1049 solution1049 = new Solution_1049();

        int[] stones = {2,7,4,1,8,1};
        System.out.println(solution1049.lastStoneWeightII(stones));
    }
}

