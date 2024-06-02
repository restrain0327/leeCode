package 单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/5/22 13:08
 */
public class Solution_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 496 下一个更大元素
        // 存nums1的数据 方便后面判断是否在nums2里
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 将nums1存进hashmap里面
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        // 因为没有比当前数大的就是-1, 有的话会覆盖
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        // 栈里存下标
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] < nums2[stack.peek()]){
                stack.push(i);
            }else if (nums2[i] > nums2[stack.peek()]){
                // 后面的大于前面的
                while (!stack.empty() && nums2[i] > nums2[stack.peek()]){
                    if (hashMap.containsKey(nums2[stack.peek()])){
                        res[hashMap.get(nums2[stack.peek()])] = nums2[i];
                    }
                    //包括或者不包括都要弹出
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1, 3, 4, 2};

        for (int i = 0; i < new Solution_496().nextGreaterElement(nums1, nums2).length; i++) {
            System.out.println(new Solution_496().nextGreaterElement(nums1, nums2)[i]);
        }
    }
}
