package leetcode.hard;

import java.util.*;

public class maxNumber {
    public static void main(String[] args) {
        new maxNumber().maxNumber(new int[]{4,9}, new int[]{8,9}, 3);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return nums1;
    }

    public int getMax(int nums[], int b1, int end) {
        int max = -1, index = -1;
        for (int i = b1 + 1; i < end && i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
//9   7   1
//nums1.length + nums2.length - k                      3
//8 9 2 4 5  b1 = 1   nums1.length + num2.length - k + curIndex + (b1+1)
//
//       lest = k - curIndex - (num2.length - b2 - 1)   6 - 4  2
//        nums1.length + nums2.length - k + curIndex - b2 - 1 + 1;   5 - 2 =3
//3 5 6 7    b2 = -1


// 4 7 4 6
// 4 4 8