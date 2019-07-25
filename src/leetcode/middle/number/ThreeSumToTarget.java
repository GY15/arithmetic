package leetcode.middle.number;

import java.util.Arrays;

public class ThreeSumToTarget {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2;i++){
            if (i == 0 || (i != 0 && nums[i] != nums[i-1])){
                int start = i + 1;
                int end = nums.length -1 ;
                while(start<end){
                    int total = nums[start]+nums[end]+nums[i];
                    int offset = Math.abs(total-target);
                    if (offset<Math.abs(target-min)){
                        min = total;
                    }
                    if ((nums[start] + nums[end] + nums[i] > target)) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return min;
    }
}
