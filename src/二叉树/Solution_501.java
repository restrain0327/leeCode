package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution_501 {
    TreeNode pre;
    List<Integer> tmpResult = new ArrayList<>();
    int maxCount;
    int Count;

    public int[] findMode(TreeNode root) {
        pre = null;
        tmpResult = new ArrayList<>();
        maxCount = 0;
        Count = 0;

        find(root);

        int[] result = new int[tmpResult.size()];
        for (int i = 0; i < tmpResult.size(); i++) {
            result[i] = tmpResult.get(i);
        }
        return result;
    }

    public void find(TreeNode root){
        if (root == null)
            return;

        //左
        find(root.left);

        //中
        if (pre == null || root.val != pre.val){
            Count = 1;
        }else if (root.val == pre.val){
            Count++;
        }

        //更新结果以及maxcount
        if (Count > maxCount){
            tmpResult.clear();
            tmpResult.add(root.val);
            maxCount = Count;
        }else if (Count == maxCount)
            tmpResult.add(root.val);

        pre = root;

        find(root.right);
    }
}
