package 二叉树;

import java.lang.reflect.Field;

public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        if (compare(root) == -1){
            return false;
        }

        return true;
    }

    public int compare(TreeNode root){
        if (root == null)
            return 0;

        //左
        int leftHeight = compare(root.left);
        if (leftHeight == -1)
            return -1;
        //右
        int rightHeight = compare(root.right);
        if (rightHeight == -1)
            return -1;


        int result = 0;
        if (Math.abs(leftHeight - rightHeight) > 1){
            //高度差超过1
            result = -1;
        }else {
            result = 1 + Math.max(leftHeight, rightHeight);
        }

        return result;
    }
}
