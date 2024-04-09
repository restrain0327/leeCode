package 链表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode cur = head;

        Set list = new HashSet<ListNode>();

        while (cur.next != null){

            if (list.contains(cur.next)){
                return cur.next;
            }
            list.add(cur);
            cur = cur.next;
        }

        return null;
    }
}
