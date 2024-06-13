package 练习.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/12 11:09
 */
public class Solution_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 有多少小于当前数字的数字
        // 利用map进行比较
        int len = nums.length;
        int[] res = Arrays.copyOf(nums, len);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
//        for (int num : nums) {
//            System.out.println(num);
//        }
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(res[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] ints = new Solution_1365().smallerNumbersThanCurrent(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
