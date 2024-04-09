package 贪心算法;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int sum = Integer.MIN_VALUE;
        int count = 0;

        for (int i=0; i< nums.length; i++){
            count += nums[i];
            if (count > sum){
                sum = count;
            }

            if (count <= 0){
                //遇到负数,重置
                count = 0;
            }
        }

        return sum;
    }
}
