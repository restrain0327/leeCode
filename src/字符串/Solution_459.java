package 字符串;

public class Solution_459 {
    //给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    public boolean repeatedSubstringPattern(String s) {
        int j = -1;

        char[] s_chars = s.toCharArray();
        int[] next = new int[s_chars.length];
        next[0] = j;
        for (int i = 1; i < s_chars.length; i++) {
            while (j>=0 && s_chars[i] != s_chars[j+1]){
                j = next[j];
            }

            if (s_chars[i] == s_chars[j+1]){
                j++;
            }
            next[i] = j;
        }

        int len = next.length;
        if (next[len-1]>0 && len-1%(s.length()-next[len-1]) == 0){
            return true;
        }
        return false;
    }
}
