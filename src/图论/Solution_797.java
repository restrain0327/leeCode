package 图论;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/1 12:40
 */
public class Solution_797 {
    List<List<Integer>> ans;
    List<Integer> path;

    /**
     * 主体
     * @param graph 图
     * @param node 路径的最后一个节点
     */
    public void dfs(int[][] graph, int node){
        // 深搜三部曲
        // 终止条件 当路径的下一个为空 则
        if (node == graph.length - 1) {		// 如果当前节点是 n - 1，那么就保存这条路径
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[node].length; i++) {
            // 给什么node 就遍历当前节点下可以去到的路径
            // 下一个要去的节点
            int cnode = graph[node][i];
            // 加入节点
            path.add(cnode);
            dfs(graph, cnode);
            // 回溯
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        ans = new ArrayList<>();
        path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3},{3},{}};
        System.out.println(new Solution_797().allPathsSourceTarget(graph));
    }
}
