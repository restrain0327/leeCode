package 二叉树;

public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        //一直访问左子节点到底
        invertTree(root.left);
        invertTree(root.right);
        swap(root);

        return root;
    }

    public void swap(TreeNode root){
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
