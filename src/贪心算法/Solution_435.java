package 贪心算法;

import java.util.Arrays;

public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 不能直接a[0] - b[0] 负数不适合
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int sum = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]){
                // 小于 就是可以一起射
                //让这个的右区间是这个弓箭的右区间最小值
                sum++;
                //移除
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
            }
        }
        return sum;
    }
}
