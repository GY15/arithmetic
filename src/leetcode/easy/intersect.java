package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int j = 0;
        for (int i = 0; i < nums2.length;i++){
            int p = map.getOrDefault(nums2[i],0);
            if (p != 0){
                map.put(nums2[i],p-1);
                nums2[j++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(nums2,0,j);
    }
}
