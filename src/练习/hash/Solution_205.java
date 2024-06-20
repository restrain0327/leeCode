package 练习.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/20 13:05
 */
public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        // 做映射 只需要加一次
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(j)); // map1保存 s[i] 到 t[j]的映射
            }
            if (!map2.containsKey(t.charAt(j))) {
                map2.put(t.charAt(j), s.charAt(i)); // map2保存 t[j] 到 s[i]的映射
            }
            // 无法映射，返回 false
            if (map1.get(s.charAt(i)) != t.charAt(j) || map2.get(t.charAt(j)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(new Solution_205().isIsomorphic(s, t));
    }
}
