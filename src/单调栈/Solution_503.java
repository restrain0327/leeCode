package 单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/22 13:44
 */
public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        // 503 下一个更大的元素2
        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int size = nums.length;

        stack.push(0);
        for (int i = 1; i < size*2; i++) {
            // 扩展数组 等于循环 循环就想着扩展数组
            while (!stack.empty() && nums[i%size] > nums[stack.peek()]){
                res[stack.peek()] = nums[i%size];
                stack.pop();
            }
            stack.push(i%size);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        int[] ints = new Solution_503().nextGreaterElements(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
