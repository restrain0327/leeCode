package 贪心算法;

public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            if (curSum < 0){
                // 最后一个 i+1 就是 0
                startIndex = (i + 1) % gas.length;
                curSum = 0;
            }
        }

        // 全部大于0 则肯定可以走完 反之则走不完
        if (totalSum < 0){
            return -1;
        }

        return startIndex;
    }
}
