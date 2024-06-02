package 图论;

import java.util.Arrays;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/1 13:14
 */
public class Solution_200 {

    boolean[][] visited;
    int[][] dir = {
            {0, 1}, //right
            {1, 0}, //down
            {-1, 0}, //up
            {0, -1} //left
    };
    public int numIslands(char[][] grid) {
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][]grid, int x, int y){
        // 终止条件
        if(visited[x][y] || grid[x][y] == '0')
            return;

        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;
            dfs(grid, nextX, nextY);
        }
    }
}
