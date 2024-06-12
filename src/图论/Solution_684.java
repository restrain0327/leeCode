package 图论;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/11 18:53
 */
public class Solution_684 {
    int[] father;
    public int[] findRedundantConnection(int[][] edges) {
        int n = 1005;
        father = new int[n];
        init(n);

        for (int i = 0; i < edges.length; i++) {
            // 如果是两个节点根节点一样 则代表这两个节点的边可以去掉了
            if (isSame(edges[i][0], edges[i][1])){
                return edges[i];
            }else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;
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
