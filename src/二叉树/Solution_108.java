package 二叉树;

import java.util.Arrays;

public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return Helper(nums, 0, nums.length);
    }

    public TreeNode Helper(int[] nums, int left, int right){
        if (left >= right)
            return null;

        if (right - left == 1){
            return new TreeNode(nums[left]);
        }
        //左闭右开
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = Helper(nums, left, mid);
        root.right = Helper(nums, mid + 1, right);

        return root;
    }
}
