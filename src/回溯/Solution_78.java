package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_78 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startindex){
        result.add(new LinkedList<>(path));
        // 终止条件
        if (startindex > nums.length)
            return;

        for (int i = startindex; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();
        }
    }
}
