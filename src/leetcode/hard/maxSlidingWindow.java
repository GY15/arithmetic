package leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class maxSlidingWindow {
    //239
    public static void main(String[] args) {
        new maxSlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
//        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i - 1; j >= 0 && i - j < k ; j--){
                if (nums[j] >= nums[i]){
                    break;
                }else{
                    nums[j] = nums[i];
                }
            }
        }
        int[] res = Arrays.copyOfRange(nums,0,nums.length-k+1);
        return res;
    }
}
