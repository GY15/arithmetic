package leetcode.middle.arrays;

public class findPeakElement {
    //162
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums[0] > nums[1]) {
            return 0;
        }else if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        return findPeakInRange(nums,0,nums.length);
    }

    private int findPeakInRange(int[] nums, int begin, int end) {
        int middle = (begin + end)/2;
        if (nums[middle] < nums[middle-1]){
            return findPeakInRange(nums,begin,middle);
        }
        if (nums[middle] > nums[middle-1]){
            if (nums[middle] > nums[middle+1]){
                return middle;
            }else{
                return findPeakInRange(nums,middle,end);
            }
        }
        return middle;
    }

    public static void main(String[] args) {
       int i = new findPeakElement().findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(i);
    }
}
