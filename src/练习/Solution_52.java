package 练习;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/7/2 10:57
 */
public class Solution_52 {
    int[][] cheers;

    int num;
    public int totalNQueens(int n) {
        // N皇后2
        // n*n的棋盘 n个皇后
        cheers = new int[n][n];
        num = 0;

        backtracking(n, 0);
        return num;
    }

    public void backtracking(int n, int row){
        // 回溯
        //终止条件
        if (row == n){
            num++;
            return;
        }
        // 主体
        // 遍历每一行, 每一行的每一个都去放女皇 判断是否能放, 能放就进入下一行, 不能就回溯, 判断下一个 ,直到放完
        for (int col=0; col<n; col++){
            if (isValid(n, row, col)){
                cheers[row][col] = 1;
                backtracking(n, row+1);
                // 回溯
                cheers[row][col] = 0;
            }
        }
    }

    public boolean isValid(int n, int row, int col){
        // 检查列
        for (int i=0; i<row; ++i){
            if (cheers[i][col] == 1){
                return false;
            }
        }

        //检查45度角
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if (cheers[i][j] == 1){
                return false;
            }
        }

        // 检查135度角
        for (int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if (cheers[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_52().totalNQueens(4));
    }
}
