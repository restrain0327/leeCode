package 二叉树;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_513 {
    public int findBottomLeftValue(TreeNode root) {
        //找出该二叉树的 最底层 最左边 节点的值。

        //用层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int res = 0;
        TreeNode cur;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (i == 0) res = cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return res;
    }
}
