package leetcode.hard;

public class minPatches {
    public static void main(String[] args) {
        int n = new minPatches().minPatches(new int[]{1,2,31,33},2147483647);
        return;
    }
    public int minPatches(int[] nums, int n) {

        long cur = 1;
        int count = 0;
        int index = 0;
        if (nums.length == 0){
            return (int) (Math.log(n) + 1);
        }
        while(cur <= n){
            if (index == nums.length){
                return count + (int) (Math.log(n/cur) );
            }else  if (cur == nums[index]){
                cur += cur;
                index++;
            } else if (cur > nums[index]) {
                cur += nums[index++];
            } else {
                count++;
                cur += cur;
            }
        }
        return count;
    }
}
