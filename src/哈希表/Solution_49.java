package 哈希表;

import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map map = new HashMap<String, ArrayList<String>>();
        String sort_str;

        for (String str : strs) {
            //排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            sort_str = String.valueOf(array);

            //判断
//            ArrayList<String> list = map.containsKey(sort_str) ? (ArrayList<String>) map.get(sort_str) : new ArrayList<>();
            ArrayList<String> list = (ArrayList<String>) map.getOrDefault(sort_str, new ArrayList<>());

            list.add(str);
            map.put(sort_str, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
