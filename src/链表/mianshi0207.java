package 链表;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class mianshi0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        //判断那条长度长
        //默认A大于B
        if (lenA < lenB){
            //交换,让A为最长的那条
            //交换长度
            int tmplen = 0;
            tmplen = lenA;
            lenA = lenB;
            lenB = tmplen;

            //交换头结点
            ListNode tmp = curA;
            curA = curB;
            curB = tmp;
        }

        //让两条链表尾部对齐
        int dis_len = lenA - lenB;

        while (dis_len-- > 0){
            curA = curA.next;
        }

        //开始比较
        ListNode node = null;
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return node;

        //双指针法
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;
    }
}
