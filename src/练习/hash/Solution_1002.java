package 练习.hash;

import 图论.Solution_1020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/21 11:31
 */
public class Solution_1002 {
    public List<String> commonChars(String[] words) {
        //查找公用字符
        // 直接用hash

        int[] arrChars = new int[26];
        List<String> res = new ArrayList<>();

        // 初始化
        for (int i = 0; i < words[0].length(); i++) {
            char c = words[0].charAt(i);
            int num = c - 'a';
//                System.out.println(num);
            arrChars[num]++;
        }



        for (int i = 1; i < words.length; i++) {
            int[] tmpChars = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);

                int num = c - 'a';
                tmpChars[num]++;
            }

            // 将相同的最小值留下
            for (int k = 0; k < tmpChars.length; k++) {
                arrChars[k] = Math.min(tmpChars[k], arrChars[k]);
            }
        }

        // 将字符转换成字符串
        for (int i = 0; i < arrChars.length; i++) {
            int len = arrChars[i];
            while (len>0){
                // 记住这个数字转为字符串
                String value = String.valueOf((char) (i+'a'));
                System.out.println(value);
                res.add(value);
                len--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strings = {"cool","lock","cook"};
        new Solution_1002().commonChars(strings);
    }
}
