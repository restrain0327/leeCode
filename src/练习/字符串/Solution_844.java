package 练习.字符串;

import java.util.Stack;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/23 12:01
 */
public class Solution_844 {
    public boolean backspaceCompare(String s, String t) {
        // 比较含退格的字符串 退格就是删除上一个元素
        // 用栈来

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#'){
                // 不是退格
                stack.push(c);
            }else {
                if (!stack.empty()){
                    // 当栈不为空才弹出
                    stack.pop();
                }
            }
        }

        s = stack.toString();
        stack.clear();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#'){
                // 不是退格
                stack.push(c);
            }else {
                if(!stack.empty()){
                    // 当栈不为空才弹出
                    stack.pop();
                }
            }
        }

        t = stack.toString();

        if (s.equals(t)){
            return true;
        }

        return false;
    }
}
