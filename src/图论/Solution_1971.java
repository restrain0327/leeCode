package 图论;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/11 12:14
 */
public class Solution_1971 {
    int[] father;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //寻找图中是否存在路径
        // 用到并查集
        father = new int[n];
        init(n);
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0], edges[i][1]);
        }

        return isSame(source, destination);
    }

    // 模板
    public void init(int n){
        for (int i = 0; i < n; i++) {
            // 初始化
            father[i] = i;
        }
    }

    public int find(int u){
        if (u == father[u]){
            return u;
        }else {
            // 路径压缩
            father[u] = find(father[u]);
            return father[u];
        }
    }

    public boolean isSame(int u, int v){
        u = find(u);
        v = find(v);
        return v == u;
    }

    public void join(int u, int v){
        u = find(u);
        v = find(v);
        if (u == v)
            return;
        father[v] = u;
    }
}
