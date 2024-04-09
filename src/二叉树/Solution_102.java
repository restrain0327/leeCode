package 二叉树;

import java.util.*;

public class Solution_102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res_list = new ArrayList<>();
            //二叉树的层序遍历
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) queue.add(root);
            TreeNode cur;

            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                while (size>0){
                    cur = queue.poll();
                    list.add(cur.val);
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    size--;
                }
                res_list.add(list);
            }

            return res_list;
        }
    }
}
