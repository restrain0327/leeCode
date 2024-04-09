package 贪心算法;

import java.util.Arrays;
import java.util.Collections;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        // 分发饼干
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int start = 0;

        for (int i=0; i<s.length && start<g.length; i++){
            if (s[i]>=g[start]){
                res++;
                start++;
            }
        }

        return res;
    }
}
