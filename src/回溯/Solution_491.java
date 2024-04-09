package 回溯;

import java.util.*;

public class Solution_491 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex){
        // 终止条件
        if (startIndex > nums.length)
            return;

        if (path.size() > 1){
            //记得， 老是忘
            result.add(new LinkedList<>(path));
        }
        //单层去重
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i< nums.length; i++){
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || hs.contains(nums[i]))
                continue;
            hs.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();

        }
    }
}
