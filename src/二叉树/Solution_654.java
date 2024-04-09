package 二叉树;

public class Solution_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return Helper(nums, 0, nums.length);
    }

    public TreeNode Helper(int[] nums, int left, int right){
        //让空指针进来
        //叶子节点
        if (left >= right) return null;

        //拿到最大下标
        int maxNum = left;
        for (int i = left+1; i < right; i++) {
            if (nums[i] > nums[maxNum]) maxNum = i;
        }

        TreeNode root = new TreeNode(nums[maxNum]);
        //递归左右子树
        root.left = Helper(nums, left, maxNum);
        root.right = Helper(nums, maxNum+1, right);

        return root;
    }
}
