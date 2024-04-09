package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_194 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res_list = new ArrayList<>();
        //二叉树的层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        TreeNode cur;
        //每层最后一个
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                cur = queue.poll();
                if (size==1) res_list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                size--;
            }
        }
        return res_list;
    }
}
