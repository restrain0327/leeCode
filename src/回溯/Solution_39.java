package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startindex){
        //剪枝
        if (sum>target){
            return;
        }
        //终止条件
        if (sum == target){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startindex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates, target, sum, i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
