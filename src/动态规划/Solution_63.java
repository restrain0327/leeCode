package 动态规划;

public class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        /**
         * dp数组的含义:
         * 0为前面有障碍物 不经过
         * 1为前面有路径经过
         */
        // 开头和结尾遇到障碍物
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }

        //初始化
        for (int i = 0; i < obstacleGrid.length; i++) {
            //宽
            if (obstacleGrid[i][0] != 1){
                dp[i][0] = 1;
            }else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            //长
            if (obstacleGrid[0][i] != 1){
                dp[0][i] = 1;
            }else {
                break;
            }
        }

        //开始遍历
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] ==0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else {
                    dp[i][j] = 0;
                }
//                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
