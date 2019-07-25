package leetcode.middle.arrays;

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length==1||nums.length==0){
            return nums.length;
        }
        int index = 1;
        boolean last = false;
        for (int i = 1; i < nums.length;i++){
            if (nums[i] == nums[i-1]){
                if (last){

                }else{
                    nums[index] = nums[i];
                    index++;
                    last = true;
                }
            }else{
                last=false;
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
