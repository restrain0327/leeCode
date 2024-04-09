package 二叉树;

import java.util.*;

public class Solution_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res_list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node cur;
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size() - 1;

            while (size>0){
                cur = queue.poll();
                list.add(cur.val);
                for (Node child : cur.children) {
                    queue.offer(child);
                }
                size--;
            }
            res_list.add(list);
        }
        return res_list;
    }
}
