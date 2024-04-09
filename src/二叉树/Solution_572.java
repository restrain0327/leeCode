package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //需要先遍历二叉树 获得全部节点
        List<TreeNode> result = new ArrayList<>();
        preorder(root, result);

        for (TreeNode treeNode : result) {
            if (compare(treeNode, subRoot) == true){
                return true;
            }
        }

        return false;
    }

    public void preorder(TreeNode root, List<TreeNode> result){
        //先序遍历
        //传进来根节点
        if (root == null){
            return;
        }

        result.add(root);
        preorder(root.left, result);
        preorder(root.right, result);

    }

    public boolean compare(TreeNode treeNode1, TreeNode treeNode2){
        //左null 右有值
        if (treeNode1 == null && treeNode2 != null){
            return false;
        }else if (treeNode2 == null && treeNode1 != null){
            //右null 左有值
            return false;
        }else if(treeNode1 == null && treeNode2 == null) {
            return true;
        } else if (treeNode1.val != treeNode2.val){
            //都不为null，但值不同
            return false;
        }
        //值相同不能返回true 要继续向下

        //左边外侧比较右边外侧
        boolean compare1 = compare(treeNode1.left, treeNode2.left);
        boolean compare2 = compare(treeNode1.right, treeNode2.right);

        return compare1 && compare2;
    }
}
