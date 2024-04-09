package 二叉树;

public class Solution_450 {
    //删除二叉搜索树的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        //五种情况
        //没有这个节点
        if (root == null) return null;

        if (root.val == key){
            //左右子树为空
            if (root.left == null && root.right == null){
                return null;
            }
            //左子树为空 右子树不为空
            else if (root.left == null && root.right != null){
                return root.right;
            }
            //左子树不为空 右子树为空
            else if (root.left != null && root.right == null){
                return root.left;
            }else {
                //左右子树都不为空 利用二叉搜索树的特点 这里cur用left或者right都行
                TreeNode cur = root.right;
                while (cur.left != null) cur = cur.left;
                cur.left = root.left;
                return root.right;
            }
        }

        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}
