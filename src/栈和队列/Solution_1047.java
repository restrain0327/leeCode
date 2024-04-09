package 栈和队列;

import java.util.Stack;

public class Solution_1047 {
    //给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
    //
    //在 S 上反复执行重复项删除操作，直到无法继续删除。
    //
    //在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!stack.empty() && stack.peek() == ch){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }

        s = "";
        while (!stack.isEmpty()) {
            s = stack.pop() + s;
        }
        return s;
    }
}
