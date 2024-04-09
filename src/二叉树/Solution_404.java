package 二叉树;

import javax.sound.midi.MidiChannel;

public class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        //左叶子之和

        if (root == null) return 0;
        //叶子节点
        if (root.left == null && root.right == null) return 0;

        int leftsum = sumOfLeftLeaves(root.left);
        int lastmidsum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            lastmidsum = root.left.val;
        }
        int rightsum = sumOfLeftLeaves(root.right);

        int sum = leftsum+rightsum+lastmidsum;
        return sum;
    }
}
