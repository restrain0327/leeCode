package 动态规划;

public class Solution_337 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int rob(TreeNode root) {
        // 337 打家劫舍|||
        // 需要用到树的递归遍历
        if (root == null){
            return 0;
        }
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robAction(TreeNode root){
        // 结束条件
        if (root == null){
            return new int[] {0, 0};
        }

        // 后序遍历
        // 返回一个数组 包含两个值 0 是偷本身 1是不偷本身
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // 偷root
        int val1 = root.val + left[1] + right[1];
        // 不偷root 要考虑子节点 比如左子节点 比较偷左子节点和不偷子节点哪个金额大就偷哪个
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {val1, val2};
    }

}
