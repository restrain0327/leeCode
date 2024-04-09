package 栈和队列;

import java.util.Stack;

public class MyQueue {
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();


    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = (int) stack2.pop();

        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }

        return res;
    }

    public int peek() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }

        int res = (int) stack2.peek();

        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }

        return res;

    }

    public boolean empty() {
        return stack1.empty();
    }
}
