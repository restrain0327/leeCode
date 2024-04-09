package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_222 {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;

        if (root == null)
            return 0;
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            sum += size;
            while (size>0){
                cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                size--;
            }
        }
        return sum;
    }
}
