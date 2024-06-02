package 单调栈;

import java.util.Stack;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/23 18:27
 */
public class Solution_42 {
    public int trap(int[] height) {
        // 42 接雨水
        // 横向计算

        // 存下标
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        stack.push(0);
        for (int index = 1; index < height.length; index++){
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //pop up all lower value
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) res += hold;
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution_42().trap(height));
    }
}
