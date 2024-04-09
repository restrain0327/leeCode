package 字符串;

public class Solution_344 {
    public void reverseString(char[] s) {
        int len = s.length, re_len = len/2;

        if (len<=1)
            return;

        char temp;
        for (int i = 0; i < re_len; i++) {
            temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
