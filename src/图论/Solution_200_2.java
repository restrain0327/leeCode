package 图论;

import java.util.LinkedList;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/2 12:55
 */
public class Solution_200_2 {
    // 本题采用广搜
    int[][] dir = {
            {0, 1}, //right
            {1, 0}, //down
            {-1, 0}, //up
            {0, -1} //left
    };

    // 存储走过的
    boolean[][] path;

    int res;
    public int numIslands(char[][] grid){
        // 初始化

        path = new boolean[grid.length][grid[0].length];
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 每个点都要遍历 走过的跳过 为0 的也跳过
                if (!path[i][j] && grid[i][j] == '1'){
                    /**
                     * i x
                     * j y
                     */
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int x, int y){
        // 主体
        // 队列
        LinkedList<int[]> queue = new LinkedList<>();
        // 加入路径
        queue.push(new int[]{x, y});
        // 加入后马上标记为走过
        path[x][y] = true;

        // 开始遍历
        while (!queue.isEmpty()){
            int[] cur = queue.pop();
            int m = cur[0];
            int n = cur[1];

            for (int i=0; i<4; i++){
                int nextx = m + dir[i][0];
                int nexty = n + dir[i][1];

                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length){
                    continue;
                }

                if (!path[nextx][nexty] && grid[nextx][nexty] == '1'){
                    // 可以走
                    queue.push(new int[]{nextx, nexty});
                    //标记
                    path[nextx][nexty] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grip= {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','1','0'}
        };
        System.out.println(new Solution_200_2().numIslands(grip));
    }
}
