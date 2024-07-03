package 练习.贪心;

import java.util.Stack;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/7/3 12:36
 */
public class Solution_1221 {
    public int balancedStringSplit(String s) {
        // 分割平衡字符串
        // 分隔的字符串也要是平衡字符串

        int count = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') count++;
            else count--;

            //当count == 0时 说明R和L已经抵消了
            if (count == 0) sum++;
        }

        return sum;
    }
}
