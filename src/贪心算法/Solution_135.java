package 贪心算法;

import java.util.Arrays;

public class Solution_135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];

        Arrays.fill(candy, 1);

        // 从前往后判断 右边大于左边
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }

        // 左边大于右边
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]){
                // 取最大值 就是大于左边和右边
                candy[i] = Math.max(candy[i+1]+1, candy[i]);
            }
        }

        return Arrays.stream(candy).sum();
    }
}
