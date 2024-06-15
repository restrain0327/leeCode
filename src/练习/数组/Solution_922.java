package 练习.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/15 12:42
 */
public class Solution_922 {
    public int[] sortArrayByParityII(int[] nums) {
        // 922 按奇偶排序数组
        // 先找出奇数 在找出偶数 记录下标 按顺序替换

        // 初始化
        int even = 0;
        int odd = 1;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (even < nums.length){
            if (nums[even] % 2 == 1){
                arrayList.add(even);
            }
            even += 2;
        }

        while (odd < nums.length){
            if (nums[odd] % 2 == 0){
                arrayList.add(odd);
            }
            odd += 2;
        }

        // 肯定是偶数
        int size = arrayList.size();
        int od = size/2;
        for (int i = 0; od <= size-1; i++) {
            int tmp = nums[arrayList.get(i)];
            nums[arrayList.get(i)] = nums[arrayList.get(od)];
            nums[arrayList.get(od)] = tmp;
            od++;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {2,3};
        int[] ints = new Solution_922().sortArrayByParityII(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
