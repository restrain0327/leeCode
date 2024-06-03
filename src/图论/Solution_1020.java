package 图论;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/3 12:25
 */
public class Solution_1020 {

    int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    int num;

    public int numEnclaves(int[][] grid) {
        // 飞地的数量

        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 1)
                dfs(grid, i, 0);
            if(grid[i][grid[0].length - 1] == 1)
                dfs(grid, i, grid[0].length - 1);
        }


        for(int j = 1; j < grid[0].length - 1; j++){
            if(grid[0][j] == 1)
                dfs(grid, 0, j);
            if(grid[grid.length - 1][j] == 1)
                dfs(grid, grid.length - 1, j);
        }
        num = 0;

        // 遍历除了边界的
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 1)
                    num++;
            }
        }
        return num;
    }

    public void dfs(int[][] grid, int x, int y){
        //dfs
        // 终止条件
        if (grid[x][y] == 0){
            return;
        }
        // 加标记
        grid[x][y] = 0;

        for (int i=0; i<4; i++){
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];

            if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length){
                continue;
            }
            dfs(grid, nextx, nexty);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0,0,0,0}, {1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new Solution_1020().numEnclaves(graph));

    }
}
