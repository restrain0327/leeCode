package 字符串;

import java.util.PrimitiveIterator;

public class Solution_28 {
    public static int strStr(String haystack, String needle) {

        //给你两个字符串 haystack 和 needle ，
        // 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
        // 如果 needle 不是 haystack 的一部分，则返回  -1 。

        //先写一个前缀表
        int slow = -1;
        char[] needle_chars = needle.toCharArray();
        int[] next = new int[needle_chars.length];
        next[0] = slow;
        for (int fast = 1; fast < needle_chars.length; fast++) {
            //回退
            while (slow>=0 && needle_chars[fast] != needle_chars[slow+1]){
                slow = next[slow];
            }

            if (needle_chars[fast] == needle_chars[slow+1]){
                slow++;
            }

            next[fast] = slow;
        }

//        for (int i = 0; i < next.length; i++) {
//            System.out.println(next[i]);
//        }

        //遍历要匹配的字符串
        char[] haystack_chars = haystack.toCharArray();
        int needle_pos = -1;
        for (int i = 0; i < haystack_chars.length; i++) {
            while (needle_pos>=0 && haystack_chars[i] != needle_chars[needle_pos + 1]){
                needle_pos = next[needle_pos];
            }

            if (haystack_chars[i] == needle_chars[needle_pos + 1]){
                needle_pos++;
            }

            if (needle_pos == needle_chars.length-1){
                System.out.println(i - needle_chars.length - 1);
                return i - needle_chars.length + 1;
            }
        }
        System.out.println(-1);
        return -1;
    }

    public static void main(String[] args) {
        strStr("aabaabaabaaf", "aabaaf");
    }
}
