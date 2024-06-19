package 练习.链表;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/18 12:53
 */
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
//        if (head.next == null){
//            return true;
//        }
//        // 回文链表
//        // 变为数组解决就可以
//        int len = 0;
//
//        ListNode cur = head;
//        while (cur != null) {
//            len++;
//            cur = cur.next;
//        }
//
//        int[] res = new int[len];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = cur.val;
//            cur = cur.next;
//        }
//
//        // 比较回文
//        for (int i = 0, j = len - 1; i < j; i++, j--){
//            if (res[i] != res[j]){
//                return false;
//            }
//        }
//        return true;

        int len = 0;
        // 统计链表长度
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        int[] res = new int[len];
        // 将元素加到数组之中
        for (int i = 0; i < res.length; i++){
            res[i] = cur.val;
            cur = cur.next;
        }
        // 比较回文
        for (int i = 0, j = len - 1; i < j; i++, j--){
            if (res[i] != res[j]){
                return false;
            }
        }
        return true;
    }
}
