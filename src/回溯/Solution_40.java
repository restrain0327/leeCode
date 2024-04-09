package 回溯;

import java.util.*;

public class Solution_40 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backtracking(candidates, target, 0, 0, used);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startindex, boolean[] used){
        //剪枝
        if (sum > target)
            return;

        //终止条件
        if (sum == target){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startindex; i < candidates.length; i++) {
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            used[i] = true;
            backtracking(candidates, target, sum, i+1, used);
            sum-=candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }
}
