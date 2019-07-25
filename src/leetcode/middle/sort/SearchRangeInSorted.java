package leetcode.middle.sort;

public class SearchRangeInSorted {
    // 返回每一半的左右两个数组，包含起始位置和终止位置，再左右分别进行判断
    // 注意二分法并不需要用递归来做，while（begin<=end） 就行，递归可以用来做求范围的东西
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) {
            return new int[]{-1, -1};
        }
        return helper(nums, target, 0, nums.length-1);
    }
    private int[] helper(int[] nums, int target, int start, int end) {
        int leftS=-1;
        int rightS = -1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(target == nums[mid]) {
                int[] subL =  helper(nums, target, start, mid-1);
                int[] subR =  helper(nums, target, mid+1, end);
                leftS = subL[0] == -1 ? mid : subL[0];
                rightS = subR[1] == -1 ? mid : subR[1];
                break;
            } else if(target>nums[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return new int[] {leftS, rightS};
    }


    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        return findOrInsert(nums,target,0,nums.length-1);
    }

    private int findOrInsert(int[] nums, int target, int begin, int end) {
        while(begin<=end) {
            int middle = (begin+end)/2;
            if (nums[middle] == target) {
                return middle;
            }else if (nums[middle] < target){
                begin = middle+1;
            }else{
                end = middle-1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        new SearchRangeInSorted().searchInsert(new int[]{1,4,6,7,9},0);
    }
}
