package 单调栈;

import java.util.Stack;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/24 21:51
 */
public class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        // 84 柱状图中的最大面积
//        if (heights.length == 1){
//            return heights[0];
//        }

        // 首部加0
        int[] heights2 = new int[heights.length+2];
//        heights2[0] = 0;
//        for (int i = 0; i < heights.length; i++) {
//            heights2[i+1] = heights[i];
//        }
//        heights2[heights2.length-1] = 0;

        System.arraycopy(heights, 0, heights2, 1, heights.length);
        heights2[heights.length+1] = 0;
        heights2[0] = 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        stack.push(0);
        for (int i = 1; i < heights2.length; i++) {
            if (!stack.empty()){
                if (heights2[i] >= heights2[stack.peek()]){
                    // 大于等于前面的
                    stack.push(i);
                }else if (!stack.isEmpty()){
                    while (!stack.isEmpty() && heights2[i] < heights2[stack.peek()]){
                        // 拿出中间的 因为后面的比它小了
                        int mid = stack.pop();
                        if (heights2[stack.peek()] < heights2[mid]){
                            // 找到比mid 左边小的元素
                            res = Math.max(res, (i-stack.peek()-1) * heights2[mid]);
                        }
                        // 没找到就说明有和mid相同的元素 弹出 找下一个
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new Solution_84().largestRectangleArea(heights));
    }
}
