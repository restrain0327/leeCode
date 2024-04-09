package 回溯;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_46 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    // 全排列不是同层去重 是叶子去重
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums);
        return result;
    }

    public void backtracking(int[] nums){
        if (path.size() == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i< nums.length; i++){
            if (used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
