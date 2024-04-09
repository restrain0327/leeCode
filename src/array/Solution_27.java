package array;

public class Solution_27 {
    public static int removeElement(int[] nums, int val) {
        //第二种最好

        // 第一种
//        //数组长度
//        int len = nums.length;
//
//        for (int i = 0; i < len; i++) {
//            if (nums[i] == val) {
//                for (int j = i; j < len-1; j++) {
//                    nums[j] = nums[j+1];
//                }
//                len--;
//                i--;
//            }
//        }
//        return len;


        //第二种
        // 快慢指针
//        int slowIndex = 0;
//        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
//            if (nums[fastIndex] != val) {
//                nums[slowIndex] = nums[fastIndex];
//                slowIndex++;
//            }
//        }
//        return slowIndex;

        //第三种
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }
}


