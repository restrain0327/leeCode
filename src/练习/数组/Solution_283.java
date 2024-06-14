package 练习.数组;

import java.util.ArrayList;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/14 13:05
 */
public class Solution_283 {
    public void moveZeroes(int[] nums) {
//        if (nums.length == 1){
//            return;
//        }
        //必须在不复制数组的情况下原地对数组进行操作。
//        int one = 0;
//        int zero = 0;
//        //采用双指针
//
//        // 超过下标 这里不用-1 否则进不去循环 超过会在下面指针遍历去退出循环
//        while (one < nums.length && zero < nums.length){
//            //先找到0 然后找不为0的数 交换 0在顺序遍历下一个0,记录位置, 1在找下一个 重复
//            while (nums[zero] != 0){
//                //没找到就 下一个数
//                zero++;
//                if (zero > nums.length - 1){
//                    return;
//                }
//            }
//            // 找到了0就找1
//            // 这里 非0的下标要大于 0的小标,不然没得交换
//            while (one < zero || nums[one] == 0){
//                one++;
//                if (one > nums.length - 1){
//                    return;
//                }
//            }
//            // 找到了 要是大于 就交换
//            if (one > zero){
//                int tmp = nums[one];
//                nums[one] = nums[zero];
//                nums[zero] = tmp;
//            }
//            // 指向下一个下标 循环
//            zero++;
//            one++;
//        }



        // 采用更简单的双指针 快慢指针
        int fast = 0;
        int slow = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[slow] = nums[fast];

            if (nums[i] == 0){
                fast++;
            }else {
                fast++;
                slow++;
            }
        }
        while (slow < nums.length){
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        new Solution_283().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
