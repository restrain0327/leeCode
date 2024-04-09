package 字符串;

public class Solution_541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i+=(2*k)) {
            int start = i;
            int end = Math.min(start + k - 1, len - 1);

            while (start < end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start ++;
                end --;
            }
        }

        return new String(chars);
    }
}
