package 二叉树;

public class Solution_538 {
    TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        //转换成累加树， 右中左遍历

        if (root == null)
            return null;

        //右
        root.right = convertBST(root.right);

        //中
        if (pre == null)
            pre = root;
        else{
            root.val = root.val + pre.val;
            pre = root;
        }

        root.left = convertBST(root.left);

        return root;
    }
}
