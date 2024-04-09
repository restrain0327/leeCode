package 链表;

public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        //递归
        if (head == null || head.next == null){
            return head;
        }

        //当前节点的下一个节点
        ListNode next = head.next;

        //进行递归, 返回后面两个交换后的第一个
        ListNode newNode = swapPairs(next.next);

        next.next = head;
        head.next = newNode;

        return next;
    }
}
