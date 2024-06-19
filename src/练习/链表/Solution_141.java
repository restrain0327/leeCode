package 练习.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/19 18:28
 */
public class Solution_141 {
    public boolean hasCycle(ListNode head) {
//        // 环形成环
//        // 利用set来判断有无成环
//        Set<ListNode> listNodes = new HashSet<>();
//
//        ListNode cur = head;
//
//        while (cur != null){
//            if (listNodes.contains(cur)){
//                // 添加过了
//                return true;
//            }
//            listNodes.add(cur);
//            cur = cur.next;
//        }
//
//        return false;

        //判断成环 一般用快慢指针 快慢指针只要相遇 则有环
        ListNode slow = head;
        ListNode fast = head;

        // 快指针走两步 慢指针走一步
        // 这里要保证 fast的next不为空 不然null没有next 会报错
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                // 相等 成环
                return true;
            }
        }
        return false;
    }
}
