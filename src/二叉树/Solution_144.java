package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result){
        //先序遍历
        //传进来根节点
        if (root == null){
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);

    }
}
