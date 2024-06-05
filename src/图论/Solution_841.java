package 图论;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/6/5 11:51
 */
public class Solution_841 {

    boolean[] visited;

    Queue<Integer> queue;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 钥匙和房间
        // 房间数量
        int roomNum = rooms.size();
        // 记录房间是否去过
        visited = new boolean[roomNum];
        // 保存要去的房间
        queue = new LinkedList<>();

        //初始化 去0号房间
        queue.offer(0);
        visited[0] = true;

        bfs(rooms);

        // 有一个房间没去过 就返回false
        for (boolean b : visited) {
            if (!b){
                return b;
            }
        }

        return true;
    }

    public void bfs(List<List<Integer>> rooms){
        while (!queue.isEmpty()){
            // 拿出要去的房间
            int room = queue.poll();
            // 当前房间的所有钥匙
            List<Integer> list = rooms.get(room);

            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]){
                    // 拿到的房间钥匙没有去过
                    // 加入到队列中 下个循环去
                    queue.offer(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
        }
    }
}
