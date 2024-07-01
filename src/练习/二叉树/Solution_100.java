package 练习.二叉树;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/7/1 12:33
 */
public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 相同的树
        // 中序遍历

        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
