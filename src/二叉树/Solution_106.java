package 二叉树;

public class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //后序数组为空 空节点
        //后序数组最后一个元素是节点元素
        //寻找中序数组位置的切割点
        //切中序数组
        //根据左中序和右中序进行切割后序数组
        //递归处理左区间和右区间

        if (postorder == null)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length-1]);

        int i = 0;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length-1])
                break;
        }

        int[] leftInorder = new int[i];
        int[] rightInorder = new int[inorder.length - i - 1];

        System.arraycopy(inorder, 0, leftInorder, 0, i+1);
        System.arraycopy(inorder, i+2, rightInorder, 0, inorder.length - i - 2);

        int[] leftPostorder = new int[leftInorder.length];
        int[] rightPostorder = new int[rightInorder.length];

        System.arraycopy(postorder, 0, leftPostorder, 0, leftInorder.length);
        System.arraycopy(postorder, leftInorder.length-1, rightPostorder, 0, rightPostorder.length);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
}
