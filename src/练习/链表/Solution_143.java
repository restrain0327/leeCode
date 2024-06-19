package 练习.链表;

import java.util.ArrayList;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/19 17:39
 */
public class Solution_143 {
    public void reorderList(ListNode head) {
        // 重排链表
        // 结合数组 集合重排

        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        // 添加进来
        while (cur != null){
            nodeList.add(cur);
            cur = cur.next;
        }

        // 初始化
        cur = head;

        int left = 1, right = nodeList.size()-1;
        int num = 1;
        while (left <= right){
            if (num % 2 == 0){
                // 偶数
                cur.next = nodeList.get(left);
                left++;
            }else {
                //奇数
                cur.next = nodeList.get(right);
                right--;
            }
            num++;
            cur = cur.next;
        }

        // 防止成环
        cur.next = null;
    }
}
