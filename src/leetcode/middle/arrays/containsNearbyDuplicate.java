package leetcode.middle.arrays;

import java.util.*;

public class containsNearbyDuplicate {
    //219
    public static void main(String[] args) {
        new containsNearbyDuplicate().containsNearbyAlmostDuplicate(new int[]{2,1},1,1);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set  = new HashSet<>();
        for (int i = 0, j = -k; i < nums.length; i++, j++){
            if (!set.add(nums[i])){
                return true;
            }
            if (j>=0){
                set.remove(nums[j]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}
