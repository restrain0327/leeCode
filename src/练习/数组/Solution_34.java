package 练习.数组;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/17 12:44
 */
public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        //在排序数组1中查找元素的第一个和最后一个
        // 双指针
        int left = -1;
        int right = -1;

        for (int i = 0; i < nums.length; i++) {
            if (left == -1 && nums[i] == target){
                // 找到第一个元素
                left = i;
            }

            if (left != -1 && nums[i] == target){
                // 找到第一个元素后面的元素
                right = i;
            }

            if (left != -1 && nums[i] != target){
                // 找到了最后一个 退出循环
                break;
            }
        }
        return new int[]{left, right};
    }
}
