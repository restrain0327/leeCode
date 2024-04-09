package 贪心算法;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //按照绝对值进行排序 从大到小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k>0){
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k%2 == 1) nums[nums.length-1] = -nums[nums.length-1];
        return Arrays.stream(nums).sum();

    }
}
