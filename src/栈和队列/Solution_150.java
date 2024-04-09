package 栈和队列;

import java.util.Stack;

public class Solution_150 {
    public int evalRPN(String[] tokens) {
        //给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
        //请你计算该表达式。返回一个表示表达式值的整数。
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            //数字进去 符号则出来两个数字 算完塞回去
            if (tokens[i].equals("+") ){
                stack.push(stack.pop() + stack.pop());
                continue;
            }

            if (tokens[i].equals("-")){
                stack.push(-stack.pop() + stack.pop());
                continue;
            }

            if (tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
                continue;
            }

            if (tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
                continue;
            }

            stack.push(Integer.parseInt(tokens[i]));
        }

       return stack.peek();
    }
}

