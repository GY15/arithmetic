package leetcode.hard;

import java.util.HashMap;

public class longestConsecutive {
    public static void main(String[] args) {
        new longestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int max =0;
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            int left = 0, right = 0;
            if (map.containsKey(nums[i]-1)){
                left = map.get(nums[i] - 1);
            }
            if (map.containsKey(nums[i]+1)){
                right = map.get(nums[i] + 1);
            }
            max = Math.max(max,right+left+1);
            map.put(nums[i],left + right + 1);
            if (left != 0){
                map.put(nums[i] - left, left+right+1);
            }
            if (right != 0){
                map.put(nums[i] + right, left+right+1);
            }
        }
        return max;
    }
}
