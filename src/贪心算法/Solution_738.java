package 贪心算法;

import java.util.Arrays;

public class Solution_738 {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();

        int flat = chars.length;

        for (int i = chars.length-2; i >= 0; i--) {
            if (chars[i] > chars[i+1]){
                chars[i]--;
                flat = i;
            }
        }

        for (int i = flat+1; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
