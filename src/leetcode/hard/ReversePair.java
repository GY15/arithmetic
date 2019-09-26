package leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReversePair {
    int count = 0;

    public static void main(String[] args) {
        new ReversePair().reversePairs(new int[]{-5,-4,-3});
    }
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = ( s + e)/2;
        int cnt;
        cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }
}
