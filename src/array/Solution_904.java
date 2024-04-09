package array;

public class Solution_904 {


        public static int totalFruit(int[] fruits) {
            int n = fruits.length, ans = 0;
            int[] cnts = new int[n];
            for (int i = 0, j = 0, tot = 0; i < n; i++) {
                if (++cnts[fruits[i]] == 1) tot++;
                while (tot > 2) {
                    if (--cnts[fruits[j++]] == 0) tot--;
                }
                ans = Math.max(ans, i - j + 1);
            }
            return ans;
        }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};
        System.out.println(totalFruit(nums));
    }
}
