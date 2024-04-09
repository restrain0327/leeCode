package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums1_hash = new int[Math.max(nums1.length, nums2.length)];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1_hash[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1_hash[nums2[i]] > 0){
                list.add(nums2[i]);
                nums1_hash[nums2[i]]--;
            }

        }

        return list.stream().mapToInt(a -> a).toArray();
    }
}
