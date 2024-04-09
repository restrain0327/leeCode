package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        //存放结果
        List<String> res = new ArrayList<>();
        //存放叶子节点的路径
        List<Integer> path = new ArrayList<>();

        if (root == null){
            return res;
        }
        getPath(root, path, res);
        return res;
    }

    public void getPath(TreeNode root, List<Integer> path, List<String> res){
        path.add(root.val);
        //判断为是否叶子节点
        if (root.left == null && root.right == null){
            //是叶子节点
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()).toString());
            res.add(sb.toString());
            return;
        }

        if (root.left != null){
            getPath(root.left, path, res);
            //回溯
            path.remove(path.size() - 1);
        }

        if (root.right != null){
            getPath(root.right, path, res);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}