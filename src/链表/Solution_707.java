package 链表;

public class Solution_707 {

    static class MyLinkedList {

        int val;

        MyLinkedList next;

        int num;

        public MyLinkedList() {

        }

        public MyLinkedList(int val) {
            this.val = val;
        }

        public MyLinkedList(int val, MyLinkedList next) {
            this.val = val;
            this.next = next;
        }

        public int get(int index) {
            MyLinkedList cur = this;
            int num = 0;
            while (num != index) {
                if (cur.next != null){
                    cur = cur.next;
                    num++;
                }else {
                    return -1;
                }
            }
                return cur.val;
        }

        public void addAtHead(int val) {
            MyLinkedList new_head = new MyLinkedList(val);
            new_head.next = this;
        }

        public void addAtTail(int val) {
            int num = 0;
            MyLinkedList cur = this;
            MyLinkedList tail = new MyLinkedList(val);

            while (cur.next != null){
                cur = cur.next;
                num++;
            }

            cur.next = tail;
        }

        public void addAtIndex(int index, int val) {
            int num = 0;
            MyLinkedList cur = this;

            while (num != index - 1) {
                if (cur.next != null) {
                    cur = cur.next;
                    num++;
                } else {
                    return;
                }
            }


            MyLinkedList add = new MyLinkedList(val);
            if (cur.next != null) {
                add.next = cur.next;
                cur.next = add;
            }else {
                cur.next = add;
            }
        }



        public void deleteAtIndex(int index) {
            int num = 0;
            MyLinkedList cur = this;
            MyLinkedList dele = new MyLinkedList(val);

            while (num != index - 1) {
                if (cur.next != null) {
                    cur = cur.next;
                    num++;
                } else {
                    return;
                }
            }

            if (cur.next.next != null){
                cur.next = cur.next.next;
            }else {
                cur.next = null;
            }

        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));

    }
}
