package 练习.二叉树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/7/1 12:57
 */
public class Solution_116 {
    public Node connect(Node root) {
        // 116 这题采用层序遍历 直观
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i!=size-1){
                    node.next = queue.peek();
                }else {
                    //该层最后一个
                    node.next = null;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        new Solution_116().connect(root);
    }
}
