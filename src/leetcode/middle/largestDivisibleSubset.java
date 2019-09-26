package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestDivisibleSubset {
    public static void main(String[] args) {
        new largestDivisibleSubset().largestDivisibleSubset(new int[]{3,4,8,16});
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int index = 0;
        int last[] = new int[nums.length];
        int dp[] = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(last,-1);
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < nums.length;i++){
            int m = 0;
            for(int j = i -1;j>=0;j--){
                if(nums[i] % nums[j] == 0 && dp[j] > m){
                    m = dp[j];
                    last[i] = j;
                }
            }
            dp[i] = m+1;
            if(max < dp[i]){
                max = dp[i];
                index = i;
            }
        }
        while(last[index]!=-1){
            list.add(0,nums[index]);
            index = last[index];
        }
        list.add(0,nums[index]);
        return list;
    }
}
