package leetcode.middle.list;

public class FindMinimuminRotatedSortedArray {
    //154
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        return findInRotated(nums,0,nums.length);
    }
    int findInRotated(int[] nums, int begin, int end){
        int middle = (begin+end)/2;
        if (nums[middle] < nums[middle-1]){
            return nums[middle];
        }
        if (nums[begin] <= nums[middle-1]){
            if (nums[middle] <= nums[end-1]){
                return nums[middle];
            }else{
                return findInRotated(nums,middle,end);
            }
        }else{
            return findInRotated(nums,begin,middle);
        }
    }

    public static void main(String[] args) {
        new FindMinimuminRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2});
    }
}
