package 图论;


import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/4 12:43
 */
public class Solution_417 {
    // 四个位置
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public void dfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
        for (int[] current: position) {
            int curRow = row + current[0], curCol = col + current[1];
            // 越界
            if (curRow < 0 || curRow >= heights.length || curCol < 0 || curCol >= heights[0].length)
                continue;
            // 高度不合适或者已经被访问过了
            if (heights[curRow][curCol] < heights[row][col] || visited[curRow][curCol][sign]) continue;
            visited[curRow][curCol][sign] = true;
            dfs(heights, curRow, curCol, sign, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length, colSize = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        // 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
        // 假设太平洋的标记为 1，大西洋为 0
        boolean[][][] visited = new boolean[rowSize][colSize][2];
        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;
            dfs(heights, row, colSize - 1, 0, visited);
            dfs(heights, row, 0, 1, visited);
        }
        for (int col = 0; col < colSize; col++) {
            visited[rowSize - 1][col][0] = true;
            visited[0][col][1] = true;
            dfs(heights, rowSize - 1, col, 0, visited);
            dfs(heights, 0, col, 1, visited);
        }
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                if (visited[row][col][0] && visited[row][col][1]) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(row);
                    arrayList.add(col);
                    ans.add(arrayList);
                }
            }
        }
        return ans;
    }
}
