package 贪心算法;

import java.util.ArrayList;
import java.util.List;

public class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        // 先对 s 拿到每一个字母的最远距离
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] hash = new int[26];

        for (int i = 0; i < len; i++) {
            hash[chars[i] - 'a'] = i;
        }


        // 划分区间
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            right = Math.max(hash[chars[i] - 'a'], right);
            if (right == i){
                res.add(right - left + 1);
                left = i+1;
            }
        }
        return res;
    }
}
