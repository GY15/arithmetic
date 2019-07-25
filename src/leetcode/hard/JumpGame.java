package leetcode.hard;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        nums[nums.length-1]=0;
        int minIndex = nums.length-1;
        for (int i = nums.length-2;i>=0;i--){
            nums[i]=getMin(nums,i+1,Math.min(minIndex,i+nums[i]))+1;
            if (nums[i] <= nums[minIndex]){
                minIndex = i;
            }
        }
        return nums[0];
    }

    private int getMin(int nums[],int l, int r) {
        int min=nums[l];
        for (int i=l;i<=r;i++){
            min = Math.min(nums[i],min);
        }
        return min;
    }
}
