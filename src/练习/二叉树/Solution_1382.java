package 练习.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/7/1 11:43
 */
public class Solution_1382 {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        getNum(root);
        return tree(0, list.size());
    }

    public TreeNode tree(int left, int right){
        // 构造二叉平衡树
        // = 也可以构造一个
        if (left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = tree(left, mid-1);
        root.right = tree(mid+1, right);
        return root;
    }

    public void getNum(TreeNode root){
        if (root == null){
            return;
        }
        // 中序遍历
        getNum(root.left);
        list.add(root.val);
        getNum(root.right);
    }
}
