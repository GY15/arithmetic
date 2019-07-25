package leetcode.middle.number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumToZero {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new LinkedList<>();
        for (int i = 0; i < nums.length-2;i++){
            if (i == 0 || (i != 0 && nums[i] != nums[i-1])){
                int target = 0 - nums[i];
                int start = i + 1;
                int end = nums.length -1 ;
                while(start<end){
                    if (nums[start]+nums[end]==target){
                        res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        while (start < end && nums[start] == nums[start+1]) start++;
                        while (start < end && nums[end] == nums[end-1]) end--;
                        start++; end--;
                    } else{
                        if ((nums[start] + nums[end] > target)) {
                            end--;
                        } else {
                            start++;
                        }
                    }
                }
            }
        }
        return res;
    }

}
