package 哈希表;

import java.util.HashSet;
import java.util.Set;

public class Solution_202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextNumber(n);
        while (slow != fast){
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }
        return slow == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
