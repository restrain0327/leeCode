package 哈希表;

import java.util.HashMap;

public class Solution_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int k : nums1) {
            for (int i : nums2) {
                if (hashMap.containsKey(k + i)) {
                    hashMap.put(k + i, hashMap.get(k + i) + 1);
                } else {
                    hashMap.put(k + i, 1);
                }
            }
        }

        int count = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                if (hashMap.containsKey(0 - i - j)){
                    count += hashMap.get(0 - i - j);
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        if (hashMap.containsKey(1)){
            hashMap.put(1,hashMap.get(1)+1);
        }

        System.out.println(hashMap.get(1));
    }
}


