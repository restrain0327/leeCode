package 图论;

import java.util.*;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/5 10:56
 */
public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 单词接龙 一次只能变一个字符
        // wordlist转换成set 查询效率更高
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        //初始化
        map.put(beginWord, 1);
        queue.offer(beginWord);

        while (!queue.isEmpty()){
            // 拿出
            String word = queue.poll();
            int path = map.get(word);

            //转换成字符数组 方便

            for (int i = 0; i < word.length(); i++) {
                // 每次循环重新来 就不用重新赋值为最初的
                char[] wordCharArray = word.toCharArray();
                // 每个字符都替换成26个字符试试
                for (char j='a'; j<='z'; j++){
                    wordCharArray[i] = j;
                    //得到新字符串
                    // 要用String.valueOf方法 用arrays.tostring会返回数组字符串 比如[1, 2, 3, 4, 5] 结果就会错误
                    String wordCharArrayString = String.valueOf(wordCharArray);

                    //判断
                    if (endWord.equals(wordCharArrayString)){
                        return path + 1;
                    }

                    if (set.contains(wordCharArrayString) && !map.containsKey(wordCharArrayString)){
                        // 有这个字符串 并且没有遍历过
                        map.put(wordCharArrayString, path+1);
                        queue.offer(wordCharArrayString);
                    }

                }
            }
        }
        return 0;
    }
}
