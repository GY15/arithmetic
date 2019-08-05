package leetcode.middle.dp;

import java.util.Arrays;

public class maxProductSubarray {
    public static void main(String[] args) {
        new maxProductSubarray().maxProduct(new int[]{2,3,-2,-2,-2,3});
    }
    public int maxProduct(int[] nums) {
        int negative = 0;
        int cur = 0;
        int max = nums[0];
        int last = 0;

        for (int i = 0; i < nums.length;i++){
            if (nums[i] < 0){
                if (negative == 0){
                    negative = nums[i];
                    last = cur;
                    cur = 0;
                }else{
                    if (cur == 0){
                        cur = negative*nums[i];
                    }else {
                        cur *= negative*nums[i];
                    }
                    if(last!=0){
                        cur *= last;
                    }
                    negative = 0;
                    max = Math.max(max,cur);
                }
            } else if (nums[i] == 0){
                last = 0;
                negative = 0;
                cur = 0;
            } else{
                if (cur == 0){
                    cur = nums[i];
                } else {
                    cur *= nums[i];
                }
                max = Math.max(max,cur);
            }
        }
         negative = 0;
         cur = 0;
         last = 0;


        for (int i = nums.length-1; i >=0;i--){
            if (nums[i] < 0){
                if (negative == 0){
                    negative = nums[i];
                    last = cur;
                    cur = 0;
                }else{
                    if (cur == 0){
                        cur = negative*nums[i];
                    }else {
                        cur *= negative*nums[i];
                    }
                    if(last!=0){
                        cur *= last;
                    }
                    negative = 0;
                    max = Math.max(max,cur);
                }
            } else if (nums[i] == 0){
                last = 0;
                negative = 0;
                cur = 0;
            } else{
                if (cur == 0){
                    cur = nums[i];
                } else {
                    cur *= nums[i];
                }
                max = Math.max(max,cur);
            }
        }


        return max;
    }
}
