package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int num = 0;
        TreeNode cur;
        if (root == null)
            return num;

        queue.add(root);

        while (!queue.isEmpty()){
            num++;
            int size = queue.size();
            while (size>0){
                cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                size--;
            }
        }
        return num;
    }
}
