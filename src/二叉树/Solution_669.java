package 二叉树;

public class Solution_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        if (root.val < low){
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }else if (root.val > high){
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
