package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_54 {
    public  List<Integer> spiralOrder(int[][] matrix) {
        //列数
        int x = matrix[0].length;

        //行数
        int y = matrix.length;

        //循环次数
        int loop = 0;

        int i = 0,j = 0 ,start = 0, n = 0;
        int[] arr = new int[x*y];

        if (x == 1 && y == 1){
            arr[n] = matrix[i][j];
        }

        if (y == 1){
            for ( j = start; j < x; j++) {
                arr[n++] = matrix[start][j];
            }
        }

        while (loop++ < y/2){

            //左开右闭
            if (n == x*y)
                break;

            if (x == 1){
                for ( i = start; i < y; i++) {
                    arr[n++] = matrix[i][start];
                }
                break;
            }

            //从左到右
            for (j = start; j < x - loop; j++){
                arr[n++] = matrix[start][j];
                if (n == x*y)
                    break;
            }

            //从上到下
            for (i = start; i < y - loop; i++){
                arr[n++] = matrix[i][j];
                if (n == x*y)
                    break;
            }

            //从右到左
            for (; j >= loop; j--){
                arr[n++] = matrix[i][j];
                if (n == x*y)
                    break;
            }

            //从下到上
            for (; i >= loop; i--){
                arr[n++] = matrix[i][j];
                if (n == x*y)
                    break;
            }

            start++;
        }
        if (y % 2 != 0 && x!=1 && y!=1) {
            if (i == j && x == y) {
                arr[n] = matrix[start][start];
            } else {
                i = start;
                j = start;
                int len = x - start * 2;
                for (; j < start + len; j++) {
                    arr[n++] = matrix[i][j];
                }
            }
        }

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] nums = {{1,11}, {2,12}, {3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
//        int[][] nums = {{1},{2}};

//            System.out.println(spiralOrder(nums));

    }
}
