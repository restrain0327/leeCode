package 链表;

public class Solution_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，
        // 然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。

        //虚拟头节点
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            //快指针先移动n步，和slow拉开n+1的距离,因为要删除节点的前一个节点
            fast = fast.next;
        }

        while (fast != null){
            //同步移动
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fifth;

        System.out.println(removeNthFromEnd(head, 2));
    }
}
