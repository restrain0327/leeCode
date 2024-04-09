package 字符串;

public class Solution_151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // 通过快慢指针去除空格
        chars = removeExtraSpaces(chars);
        //翻转整个数组
        reverse(chars, 0, chars.length - 1);
        //遍历 翻转单个单词
        reverseEachWord(chars);
        return new String(chars);
    }

    public char[] removeExtraSpaces(char[] chars){
        int slow = 0, fast;
        int len = chars.length;

        for (fast = 0; fast < len; fast++) {
            if (chars[fast] != ' '){
                //当快指针不等于空格时 进入一个单词 用慢指针保存
                //慢指针在每个单词中间添加一个空格 但第一个单词不用
                if (slow != 0){
                    chars[slow++] = ' ';
                }

                //进入一个单词后 遍历这个单词 让slow保存
                while (fast < len && chars[fast] != ' '){
                    chars[slow++] = chars[fast++];
                }
            }
        }

        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public void reverse(char[] chars, int left, int right){
        char tmp;
        while (left < right){
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;
        }
    }

    public void reverseEachWord(char[] chars) {
//        int slow = 0, fast;
//
//        for (fast=0; fast<=chars.length; fast++){
//            if (chars[fast] == ' ' || fast == chars.length){
//                //离开了第一个单词
//                reverse(chars, slow, fast-1);
//
//                slow = fast+1;
//            }

            int start = 0;
            //end <= s.length() 这里的 = ，是为了让 end 永远指向单词末尾后一个位置，这样 reverse 的实参更好设置
            for (int end = 0; end <= chars.length; end++) {
                // end 每次到单词末尾后的空格或串尾,开始反转单词
                if (end == chars.length || chars[end] == ' ') {
                    reverse(chars, start, end - 1);
                    start = end + 1;
                }
            }
        }

}
