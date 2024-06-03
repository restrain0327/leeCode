package 图论;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/3 13:22
 */
public class Solution_130 {
    int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public void solve(char[][] board) {

        //先便利边界
        for (int i=0; i<board.length; i++){
            if (board[i][0] == 'O'){
                dfs(board, i, 0);
            }

            if (board[i][board[0].length - 1] == 'O'){
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int j=1; j<board[0].length-1; j++){
            if (board[0][j] == 'O'){
                dfs(board, 0, j);
            }

            if (board[board.length-1][j] == 'O'){
                dfs(board, board.length-1, j);
            }
        }

        for (int i=0; i< board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y){
        if (board[x][y] != 'O'){
            return;
        }

        //将 0 变成 X
        board[x][y] = '1';

        for (int i=0; i<4; i++){
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];

            if (nextx < 0 || nexty < 0 || nextx >= board.length || nexty >= board[0].length){
                continue;
            }
            dfs(board, nextx, nexty);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };

        new Solution_130().solve(board);
    }
}
