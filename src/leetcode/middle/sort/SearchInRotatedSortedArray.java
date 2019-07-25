package leetcode.middle.sort;

public class SearchInRotatedSortedArray {
    // 通过middle begin end 判断当前target在哪一段中，再进行递归调用
    public int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        if (nums.length==1){
            return target==nums[0]?0:-1;
        }
        int begin = 0;
        int end = nums.length-1;
        return findInRotate(nums,begin,end,target);


    }
    int findInRotate(int nums[],int begin,int end,int target){
        if (nums[begin]<nums[end]){
            return  findInArray(nums,begin,end,target);
        } else{
            int middle = begin+(end-begin)/2;
            if (target==nums[middle]){
                return middle;
            } else   if (nums[begin]==target){
                return begin;
            } else   if (nums[end]==target){
                return end;
            }else {
                int res = -1;
                if (begin == middle) {
                    if (nums[end] == target) {
                        return end;
                    } else
                        return res;
                }
                if (nums[begin] < nums[middle]){

                    if (nums[begin]<target  && nums[middle]>target) {
                        res = findInArray(nums, begin, middle, target);
                        if (res != -1) {
                            return res;
                        }
                    } else {
                        res = findInRotate(nums,middle+1,end,target);
                        if (res != -1){
                            return res;
                        }
                    }
                }else{
                    if (nums[middle] < target && nums[end] > target){
                        res = findInArray(nums,  middle+1,end, target);
                        if (res != 0) {
                            return res;
                        }
                    }else {
                        res = findInRotate(nums,0,middle,target);
                        if (res!=0){
                            return res;
                        }
                    }
                }
            }
        }
        return -1;
    }
    int findInArray(int nums[], int begin,int end,int target){

        while(true) {
            int middle =begin+(end-begin)/2;

            if (begin==end){
                return nums[begin]==target?begin:-1;
            }
            if (nums[middle] < target) {
                begin = middle + 1;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                return middle;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{8,1,2,3,5,6,7},6));
    }
}













