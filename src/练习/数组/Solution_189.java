package 练习.数组;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/14 14:07
 */
public class Solution_189 {
    public void rotate(int[] nums, int k) {
        // 轮转都可以这样做

        k = k%nums.length;
        // 先翻转
        reverse(nums, 0, nums.length-1);
        // 翻转前部分
        reverse(nums, 0, k-1);
        //翻转后部分
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
}
