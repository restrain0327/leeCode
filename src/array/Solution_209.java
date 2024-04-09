package array;

public class Solution_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int len = nums.length;
        int result = Integer.MAX_VALUE;
        int sum = 0, lon;

        for (int right = 0; right < len; right++) {
            sum += nums[right];
            while (sum >= target){
                lon = right - left + 1;
                result = Math.min(result, lon);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
