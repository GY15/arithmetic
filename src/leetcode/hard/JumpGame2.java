package leetcode.hard;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2,0}));
    }
    public boolean jump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        nums[nums.length-1]=1;
        for (int i = nums.length-2;i>=0;i--){
            nums[i]=getMin(nums,i+1,i+nums[i]);
        }
        return nums[0]>0;
    }

    private int getMin(int nums[],int l, int r) {
        if (nums[l-1]+l>nums.length){
            return 1;
        }
        for (int i=l;i<=r;i++){
            if (nums[i]!=0){
                return nums[i];
            }
        }
        return 0;
    }
}
