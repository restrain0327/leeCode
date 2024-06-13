package 练习.数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/13 13:40
 */
public class Solution_1207 {
    public boolean uniqueOccurrences(int[] arr) {
//        // key 计数 value 数字
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (!map.containsKey(arr[i])){
//                map.put(arr[i], 1);
//            }else {
//                // 已经加过了 就累加
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }
//        }
//        Set<Integer> set = new HashSet<>();
//        for (Integer value : map.values()) {
//            if (!set.contains(value)){
//                // 没有这个数
//                set.add(value);
//            }else {
//                //重复了
//                return false;
//            }
//        }
//        return true;

        //哈希法
        int[] count = new int[2002];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }

        boolean[] fre = new boolean[2002];
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0){
                if (fre[count[i]]){
                    return false;
                }
                fre[count[i]] = true;
            }
        }
        return true;
    }
}
