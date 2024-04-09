package 贪心算法;

public class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        // nums只有一个
        if (nums.length == 1)
            return 1;

        int prediff = 0;
        int curdiff = 0;
        // 默认就有一个坡度
        int result = 1;

        for (int i=0; i< nums.length-1; i++){
            curdiff = nums[i+1] - nums[i];
            if ((prediff<=0 && curdiff>0) || (prediff>=0 && curdiff<0)){
                result++;
                prediff = curdiff;
            }
        }

        return result;
    }
}
