package 回溯;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_332 {
    LinkedList<String> path = new LinkedList<>();
    LinkedList<String> result;
    boolean[] used;
    public List<String> findItinerary(List<List<String>> tickets) {
        //按字典排序返回最小的行程组合 所以需要先对key排序
        tickets = tickets.stream().sorted(Comparator.comparing(innerList -> innerList.get(1))).collect(Collectors.toList());
        path.add("JFK");
        used = new boolean[tickets.size()];
        Arrays.fill(used, false);
        backtracking(tickets);
        return result;
    }
    public boolean backtracking(List<List<String>> tickets){
        //因为先加了一个JFK
        if (path.size() == tickets.size() + 1){
            result = new LinkedList<>(path);
            return true;
        }

        for (int i = 0; i<tickets.size(); i++){
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())){
                used[i] = true;
                path.add(tickets.get(i).get(1));

                if (backtracking(tickets)){
                    return true;
                }

                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
