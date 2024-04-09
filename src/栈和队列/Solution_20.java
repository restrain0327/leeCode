package 栈和队列;

import java.util.*;

public class Solution_20 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        // 栈 适合对称匹配
        Deque<Character> stack = new LinkedList<>();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                stack.push(')');
            }else if (ch == '{') {
                stack.push('}');
            }else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                stack.pop();
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }
}
