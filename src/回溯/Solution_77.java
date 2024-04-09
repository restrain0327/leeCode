package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_77 {
    //组合 回溯
    //LinkedList 是双向链表
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    public void backtracking(int n, int k, int startindex){
        //回溯就是暴力求解

        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        //n - (k - path.size()) + 1 剩余元素要大于等于需要的元素 剪枝
        for (int i = startindex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtracking(n, k, i+1);
            //回溯操作
            path.removeLast();
        }
    }
}
