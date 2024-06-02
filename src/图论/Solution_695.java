package 图论;

import java.util.LinkedList;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/2 13:36
 */
public class Solution_695 {
    int[][] dir = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };


    int area;
    boolean[][] path;
    public int maxAreaOfIsland(int[][] grid) {
        // 岛屿的最大面积
        // 我这里采用广搜 要求面积

        // 初始化
        path = new boolean[grid.length][grid[0].length];
        int res = 0;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (!path[i][j] && grid[i][j] == 1){
                    area = 0;
                    bfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    public void bfs(int[][] grid, int x, int y){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        // 标记
        path[x][y] = true;
        area++;
        // 计数
        while (!queue.isEmpty()){
            int m = queue.pop();
            int n = queue.pop();

            for (int i=0; i<4; i++){
                // 四个方向
                int nextx = m + dir[i][0];
                int nexty = n + dir[i][1];

                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length){
                    continue;
                }
                if (!path[nextx][nexty] && grid[nextx][nexty] == 1){
                    // 可以走到下一步

                    queue.offer(nextx);
                    queue.offer(nexty);
                    path[nextx][nexty] = true;
                    area++;
                }
            }
        }
    }
}
