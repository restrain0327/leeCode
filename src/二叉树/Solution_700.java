package 二叉树;

public class Solution_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode rootLeft = searchBST(root.left, val);
        TreeNode rootRight = searchBST(root.right, val);

        if (rootLeft != null && rootRight == null)
            return rootLeft;
        else if (rootLeft == null && rootRight != null)
            return rootRight;
        return null;
    }
}
