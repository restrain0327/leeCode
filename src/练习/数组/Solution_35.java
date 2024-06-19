package 练习.数组;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/17 13:24
 */
public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        // 搜索插入位置
        // 要使用logn的算法

        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 二分法 左闭右闭区间
        while (left <= right){ // 左闭右闭区间 判断条件要加=
            int middle = left + ((right - left) / 2); // 防止溢出

            if (nums[middle] > target)
                //大于目标值 右区间要变化
                right = middle - 1; //右闭区间
            else if (nums[middle] < target)
                //小于目标值 左区间要变化
                left = middle + 1;
            else
                //找到了目标值 直接返回
                return middle;
        }

        // 没找到目标值 说明数组里面没有
        // 因为是右闭区间 所以要right + 1 右开不用 + 1
        return right + 1;
    }
}
