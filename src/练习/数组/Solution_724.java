package 练习.数组;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/15 11:07
 */
public class Solution_724 {
    public int pivotIndex(int[] nums) {
        // 寻找数组的中心下标
        // 这种累加的题目 一般先累加 然后求左边为一半 拿下标
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // 当前数字
            int cur = nums[i];
            int curSum = sum - cur;

            // 不能平分 则左右两边不可能相同
            if (curSum % 2 == 1 || curSum % 2 == -1){
                leftSum += nums[i];
                continue;
            }

            if (leftSum == curSum/2){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, -1};
        System.out.println(new Solution_724().pivotIndex(nums));
    }
}
