package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_216 {
    //找出所有相加之和为 n 的 k 个数的组合 组合总和
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1);

        return result;
    }

    public void backtracking(int n, int k, int startindex){
        // 减枝
        if (sum > n) {
            return;
        }

        //终止条件
        if (path.size() == k){
            if (sum == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startindex; i <= 9; i++){
            path.add(i);
            sum += i;
            backtracking(n, k, i+1);
            path.removeLast();
            sum -= i;
        }
    }
}


