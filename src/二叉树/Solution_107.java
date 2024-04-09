package 二叉树;

import java.util.*;

public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res_list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        if (root!=null) queue.add(root);
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
        Collections.reverse(res_list);
        return res_list;
    }
}
