package 二叉树;

public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        //给你一个二叉树的根节点 root ， 检查它是否轴对称。
        return compare(root.left, root.right);

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
        boolean compare1 = compare(treeNode1.left, treeNode2.right);
        boolean compare2 = compare(treeNode1.right, treeNode2.left);

        return compare1 && compare2;
    }
}
