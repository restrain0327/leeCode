package 链表;

public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;

        while (cur != null){
            //保存当前节点的下一个节点
            tmp = cur.next;
            //转换箭头指向
            cur.next = pre;
            //下一个位置
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
