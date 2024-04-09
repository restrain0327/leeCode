package 贪心算法;

public class Solution_55 {
    public boolean canJump(int[] nums) {
        //只看覆盖范围,不看怎么覆盖的
        int cover = 0;

        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length-1){
                return true;
            }
        }

        return false;
    }
}
