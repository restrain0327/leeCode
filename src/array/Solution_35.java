package array;

public class Solution_35 {
    public static int searchInsert(int[] nums, int target) {
        //二分法
        int left = 0, right, len = nums.length, mid = 0;
        right = len - 1;

        while (left <= right){
            mid = (right + left)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 0));
    }
}
