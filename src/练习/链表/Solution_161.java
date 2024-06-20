package 练习.链表;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/20 12:39
 */
public class Solution_161 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 链表相交
        // 如果相交的话 相交后的部分都是一样的 长度也一样

        // 先求长度
        int Alen = 0;
        ListNode Anode = headA;
        while (Anode != null){
            Alen++;
            Anode = Anode.next;
        }

        int Blen = 0;
        ListNode Bnode = headB;
        while (Bnode != null){
            Blen++;
            Bnode = Bnode.next;
        }

        Anode = headA;
        Bnode = headB;

        // 长的是 Anode 后面好处理 len 也要换
        ListNode tmp;
        int tmpNum;
        if (Alen < Blen){
            tmp = Bnode;
            Bnode = Anode;
            Anode = tmp;
            tmpNum = Alen;
            Alen = Blen;
            Blen = tmpNum;
        }

        // 两个链表长度相差多少
        int len = Alen - Blen;

        System.out.println(len);

        // 移到相同位置
        while (len>0){
            Anode = Anode.next;
            len--;
        }

        while (Anode !=null){
            // 找到就返回
            if (Anode == Bnode){
                return Anode;
            }
            System.out.println(" A: " + Anode.val);
            System.out.println(" B: " + Bnode.val);
            Anode = Anode.next;
            Bnode = Bnode.next;
        }

        // 找不到相交
        return null;
    }
}
