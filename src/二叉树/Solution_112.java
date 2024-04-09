package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        targetSum -= root.val;

        if (root.left == null && root.right == null){
            return targetSum == 0;
        }
        if (root.left != null){
            boolean leftSum = hasPathSum(root.left, targetSum);
            if (leftSum)
                return true;
        }

        if (root.right != null){
            boolean rightSum = hasPathSum(root.right, targetSum);
            if (rightSum)
                return true;
        }
        return false;
    }
}
