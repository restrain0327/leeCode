package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_90 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    // 同层去重
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startindex){
        result.add(new ArrayList<>(path));
        if (startindex >= nums.length){
            return;
        }

        for (int i = startindex; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i+1);
            used[i] = false;
            path.removeLast();
        }
    }
}
