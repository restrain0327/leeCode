package array;

public class Solution_26 {
    public static int removeDuplicates(int[] nums) {
        int low = 0, fast, len = nums.length;

        for (fast = 1; fast < len; fast++) {
            if (nums[low] != nums[fast]){
                nums[++low] = nums[fast];
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
