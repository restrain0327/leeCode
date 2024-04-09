package 栈和队列;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1 = new LinkedList();
    private Queue<Integer> queue2 = new LinkedList();

    public MyStack() {

    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        int res = 0;

        while (!queue1.isEmpty()){
            res = queue1.poll();
            queue2.offer(res);
        }

//        while (!queue2.isEmpty()){
//            queue1.offer(queue2.poll());
//        }

        for (int i = 0; i < queue2.size(); i++) {
            queue1.offer(queue2.poll());
        }

        queue2.clear();

        return res;
    }

    public int top() {
        int res = 0;

        while (!queue1.isEmpty()){
            res = queue1.poll();
            queue2.offer(res);
        }

        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }

        return res;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
