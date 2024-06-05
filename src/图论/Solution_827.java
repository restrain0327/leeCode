package 图论;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/4 13:48
 */
public class Solution_827 {
    int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    int[][] visited;

    //岛屿编号
    int mark;

    int area;
    public int largestIsland(int[][] grid) {
        // 最大人工岛
        // 可以先算出全部岛屿的面积是多少 在遍历 把1都变成0一次 在算岛屿面积
        int res = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        // 存放岛屿编号
        visited = new int[grid.length][grid[0].length];
        mark = 1;

        // 先求岛屿面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                area = 0;
                if (visited[i][j] == 0 && grid[i][j] == 1){
                    dfs(grid, i, j, mark);
                    map.put(mark, area);
                    mark++;
                }
            }
        }

        // 在把每一个 0 都变成 1 求面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 没有岛屿才遍历
                if (grid[i][j] == 0){
                    // 记录连上的岛屿 防止重复连
                    Set<Integer> hashSet = new HashSet<>();
                    int allArea = 1;
                    // 往四个方向遍历 看看能连上几个岛屿
                    for (int[] position : dir) {
                        int nextx = i + position[0];
                        int nexty = j + position[1];

                        //越界
                        if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length){
                            continue;
                        }

                        // 哪个岛屿
                        int mark = visited[nextx][nexty];

                        // 已经连过了 或者 没有这个岛屿也就是为0 计算面积的时候没有它
                        if (hashSet.contains(mark) || !map.containsKey(mark)){
                            continue;
                        }

                        // 加入
                        hashSet.add(visited[nextx][nexty]);
                        allArea += map.get(visited[nextx][nexty]);

                    }
                    //统计
                    res = Math.max(res, allArea);
                }
            }
        }

        return res == Integer.MIN_VALUE ? grid.length * grid[0].length : res;
    }

    public void dfs(int[][] grid, int x, int y, int mark){
        if (visited[x][y] != 0 || grid[x][y] == 0){
            // 已经走过的 或者 没有岛屿
            return;
        }
        // 同个岛屿
        visited[x][y] = mark;
        // 面积
        area++;

        for (int i=0; i<4; i++){
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];

            if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length){
                continue;
            }

            dfs(grid, nextx, nexty, mark);
        }
    }

    public static void main(String[] args) {
        int[][] grip = {{0, 0}, {0, 0}};
        System.out.println(new Solution_827().largestIsland(grip));
    }
}
