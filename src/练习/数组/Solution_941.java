package 练习.数组;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/13 12:40
 */
public class Solution_941 {
    public boolean validMountainArray(int[] arr) {
//        if (arr.length < 3 || arr[1] <= arr[0]){
//            return false;
//        }
//
//        // 有效的山脉数组
//        int high=arr[0];
//        // 标记找到最高点
//        boolean flat = false;
//
//
//        for (int i = 1; i < arr.length; i++) {
//            if (!flat){
//                if (arr[i] > high){
//                    high = arr[i];
//                }else if (arr[i] == high){
//                    return false;
//                }else {
//                    flat = true;
//                    high = arr[i];
//                }
//            }else {
//                if (arr[i] == high){
//                    return false;
//                }else if (arr[i] > high){
//                    return false;
//                }else {
//                    high = arr[i];
//                }
//            }
//        }
//
//        return flat;

        //双指针
        if (arr.length < 3) { // 此时，一定不是有效的山脉数组
            return false;
        }
        // 双指针
        int left = 0;
        int right = arr.length - 1;
        // 注意防止指针越界
        while (left < arr.length-1 && arr[left] < arr[left + 1]) {
            left++;
        }
        // 注意防止指针越界
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        // 如果left或者right都在起始位置，说明不是山峰
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,7,20,14,15,14,10,8,2,1};
        System.out.println(new Solution_941().validMountainArray(nums));
    }
}
