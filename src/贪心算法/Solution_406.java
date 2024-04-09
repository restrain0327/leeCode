package 贪心算法;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
            }
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列);
        });

        LinkedList<int[]> linkedList = new LinkedList<>();

        for (int[] person : people) {
            linkedList.add(person[1], person);
        }

        return linkedList.toArray(new int[people.length][]);
    }
}
