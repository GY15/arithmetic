package leetcode.middle.arrays;

public class maximumGap {
    //164
    public int maximumGap(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 1; i < nums.length;i++){
            temp = Math.abs(nums[i] - nums[i-1]);
            max = Math.max(temp,max);
        }
        return max;
    }
    public static void main(String[] args) {
    }
}
