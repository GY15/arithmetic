package leetcode.hard;

public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean singleNum = (nums1.length + nums2.length) % 2 == 1;
        int medianIndex = (nums1.length + nums2.length) / 2;
        int i1=0,i2=0;
        int nums[] = new int[nums1.length+nums2.length];
        int n = 0;
        while(i1 < nums1.length && i2 < nums2.length){
            if (nums1[i1] <= nums2[i2]){
                nums[n++] = nums1[i1++];
            } else {
                nums[n++] = nums2[i2++];
            }
        }
        while (i2<nums2.length){
            nums[n++] = nums2[i2++];
        }
        while (i1 < nums1.length){
            nums[n++] = nums2[i1++];
        }
        return singleNum? nums[medianIndex]: (nums[medianIndex]+nums[medianIndex+1])/2;
    }
}
