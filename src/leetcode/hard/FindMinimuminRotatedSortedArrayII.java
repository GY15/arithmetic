package leetcode.hard;

public class FindMinimuminRotatedSortedArrayII {
    //154
    public static void main(String[] args) {
        int n =new FindMinimuminRotatedSortedArrayII().findMin(new int[]{3,1,3,3});
        System.out.println(n);
    }
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        return findInRotated(nums,0,nums.length);
    }
    int findInRotated(int[] nums, int begin, int end){
        int middle = (begin+end)/2;
        if (begin == end - 1 || begin==end){
            return nums[begin];
        }
        if(nums[begin] == nums[end-1]){
            int left = findInRotated(nums,begin,middle);
            int right = findInRotated(nums, middle, end);
            return Math.min(left,right);
        } else if(nums[begin] < nums[end-1]){
            return nums[begin];
        } else {
            if (nums[middle] <= nums[end-1]){
                if (nums[middle] < nums[middle-1]){
                    return nums[middle];
                }else{
                    return findInRotated(nums,begin,middle);
                }
            } else {
                return findInRotated(nums,middle,end);
            }
        }

    }

}
