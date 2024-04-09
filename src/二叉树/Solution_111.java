package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_111 {
    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left_height = minDepth(root.left);
        int right_height = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return 1 + right_height;
        }

        if (root.right == null && root.left != null) {
            return 1 + left_height;
        }

        return 1 + Math.min(left_height, right_height);

    }
}
