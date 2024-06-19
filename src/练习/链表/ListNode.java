package 练习.链表;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/18 12:22
 */
public class ListNode {
    // 链表类
    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int val){this.val = val;}

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
