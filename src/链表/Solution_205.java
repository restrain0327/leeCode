package 链表;

public class Solution_205 {

        public ListNode removeElements(ListNode head, int val) {
                //虚拟节点的办法
                ListNode dummy = new ListNode(-1,head);

                //当前节点的前一个节点, 初始化为虚拟节点
                ListNode pre = dummy;

                //当前节点
                ListNode cur = head;

                while (cur != null){
                        if (cur.val == val){
                                pre.next = cur.next;
                        }else {
                                pre = cur;
                        }
                        cur = cur.next;
                }

                return dummy.next;

        }
}
