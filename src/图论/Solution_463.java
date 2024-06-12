package 图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/6 12:47
 */
public class Solution_463 {
    // 上下左右 4 个方向
    int[] dirx = {-1, 1, 0, 0};
    int[] diry = {0, 0, -1, 1};

    public int islandPerimeter(int[][] grid) {
        // 每个岛屿都遍历四个方向 哪个方向没有岛屿就是到边了 就放一个边界 也就是周长
        int m = grid.length;
        int n = grid[0].length;
        int res = 0; // 岛屿周长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirx[k];
                        int y = j + diry[k];
                        // 当前位置是陆地，并且从当前位置4个方向扩展的“新位置”是“水域”或“新位置“越界，则会为周长贡献一条边
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
                            res++;
                            continue;
                        }
                    }
                }
            }
        }
        return res;
    }
}
