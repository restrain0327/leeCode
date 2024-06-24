package 练习.二叉树;


import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/24 11:29
 */
public class Solution_129 {
    List<Integer> path = new ArrayList<>();
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // 求根节点到叶节点的数字之和
        // 用递归遍历很快
        path.add(root.val);
        getNum(root);
        return sum;
    }

    public void getNum(TreeNode node){
        if (node.left == null && node.right == null){
            sum+=listToInt(path);
            return;
        }

        // 左边
        if (node.left != null){
            path.add(node.left.val);
            getNum(node.left);
            path.remove(path.size()-1);
        }

        // 右边
        if(node.right != null){
            path.add(node.right.val);
            getNum(node.right);
            path.remove(path.size()-1);
        }
    }

    public int listToInt(List<Integer> path){
        int sum = 0;
        for (Integer num:path){
            // sum * 10 表示进位
            sum = sum * 10 + num;
        }
        return sum;
    }
}
