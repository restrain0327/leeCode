package 二叉树;

public class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //二叉搜索树的公共祖先

        if (root == null)
            return null;

        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null)
                return left;
        }else if (root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null)
                return right;
        }

        return root;
    }
}
