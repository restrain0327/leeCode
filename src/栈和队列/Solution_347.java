package 栈和队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
//        给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
        //优先级队列
        //后面定义排序规则
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((num1, num2) -> num1[1] - num2[1]);
        //定义一个map去记录每个数字出现的频率
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //遍历map
            if (priorityQueue.size() < k){
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if (priorityQueue.peek()[1] < entry.getValue()){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}
