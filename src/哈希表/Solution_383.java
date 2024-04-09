package 哈希表;

public class Solution_383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] char_nums = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
             char_nums[magazine.charAt(i) - 'a'] ++;
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            if (char_nums[ransomNote.charAt(j) - 'a'] == 0){
                return false;
            }

            char_nums[ransomNote.charAt(j) - 'a'] --;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ab";
        System.out.println(canConstruct(s1, s2));
    }
}
