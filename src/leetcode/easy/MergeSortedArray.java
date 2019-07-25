package leetcode.easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*nums1的空间在后面，就要考虑从后往前排*/
        int nums[] =new int[m+n];
        int k = 0;
        int i=0,j=0;
        while(i<m&&j<n){
            if (nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else {
                nums[k++] = nums2[j++];
            }
        }
        while(i<m){
                nums[k++] = nums1[i++];
        }
        while(j<n){
                nums[k++] = nums2[j++];
        }
        nums1 = nums;
    }
}
