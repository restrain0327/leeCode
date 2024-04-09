package 贪心算法;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        // 先对points排序
        // 不能直接a[0] - b[0] 负数不适合
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int sum = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]){
                // 后一个左区间 大于 前一个右区间
                sum++;
            }else {
                // 小于等于 就是可以一起射
                //让这个的右区间是这个弓箭的右区间最小值
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }
        return sum;
    }
}
