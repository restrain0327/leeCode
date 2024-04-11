package 动态规划;

public class Solution_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //474 一和零

        //这题是01背包
        //重量有两个维度


        //实际还是一维01背包 只是重量有两个维度 所以用二维数组
        int[][] dp = new int[m+1][n+1];

        //初始化 都为0

        //先遍历物品
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            //先计算单个的重量
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '0'){
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            System.out.println(zeroNum + " " + oneNum);

            //在遍历背包 一维要倒叙 这里背包重量的两个维度都需要倒叙
            for (int i=m; i>=zeroNum; i--){
                for (int j = n; j>=oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution_474 solution474 = new Solution_474();
        String[] strings = {"10", "0001", "111001", "1", "0"};

        System.out.println(solution474.findMaxForm(strings, 5, 3));
    }
}
