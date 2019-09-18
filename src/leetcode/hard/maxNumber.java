package leetcode.hard;

public class maxNumber {
    public static void main(String[] args) {
        new maxNumber().maxNumber(new int[]{    4,6,9,1,0,6,3,1,5,2,8,3,8,8,4,7,2,0,7,1,9,9,0,1,5,9,3,9,3,9,7,3,0,8,1,0,9,1,6,8,8,4,4,5,7,5,2,8,2,7,7,7,4,8,5,0,9,6,9,2},
                new int[]{            9,9,4,5,1,2,0,9,3,4,6,3,0,9,2,8,8,2,4,8,6,5,4,4,2,9,5,0,7,3,7,5,9,6,6,8,8,0,2,4,2,2,1,6,6,5,3,6,2,9,6,4,5,9,7,8,0,7,2,3},
                60);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int b1 = -1, e1 = nums1.length + nums2.length - k + 1,
                b2 = -1, e2 =  nums1.length + nums2.length - k + 1;
        initNext(res,nums1,b1,e1,nums2,b2,e2,0,k);
        return res;
    }
    public void initNext(int res[], int[] nums1, int b1, int e1, int[] nums2, int b2, int e2, int curIndex,int k){
        if (curIndex == res.length)
            return;
        int index1 = getMax(nums1,b1,e1);
        int index2 = getMax(nums2,b2,e2);
        if (index1 == -1 || ( index2 != -1 && nums1[index1] < nums2[index2])){
            if (res[curIndex] > nums2[index2]){
                return;
            }
            if(curIndex + 1 < k && res[curIndex] < nums2[index2]) res[curIndex+1] = -1;

            res[curIndex++] = nums2[index2];
            b2 = index2;
            e1 =  nums1.length + nums2.length - k + curIndex - b2;
            e2 = nums1.length + nums2.length - k + curIndex - b1;
            initNext(res,nums1,b1,e1,nums2,b2,e2,curIndex,k);
        }else if (index2 == -1 || nums1[index1] > nums2[index2]){
            if (res[curIndex] > nums1[index1]){
                return;
            }
            if(curIndex + 1 < k && res[curIndex] < nums1[index1]) res[curIndex+1] = -1;

            res[curIndex++] = nums1[index1];
            b1 = index1;
            e1 =  nums1.length + nums2.length - k + curIndex - b2;
            e2 = nums1.length + nums2.length - k + curIndex - b1;
            initNext(res,nums1,b1,e1,nums2,b2,e2,curIndex,k);
        }else if (nums1[index1] == nums2[index2]){
            if (res[curIndex] > nums1[index1]){
                return;
            }
            if(curIndex + 1 < k && res[curIndex] < nums1[index1]) res[curIndex+1] = -1;

            res[curIndex++] = nums1[index1];

            e1 =  nums1.length + nums2.length - k + curIndex - b2;
            e2 = nums1.length + nums2.length - k + curIndex - index1;
            initNext(res,nums1,index1,e1,nums2,b2,e2,curIndex,k);

            e1 =  nums1.length + nums2.length - k + curIndex - index2;
            e2 = nums1.length + nums2.length - k + curIndex - b1;
            initNext(res,nums1,b1,e1,nums2,index2,e2,curIndex,k);
        }

    }
    public int getMax(int nums[], int b1, int end){
        int max = -1,index = -1;
        for (int i = b1 + 1; i < end && i < nums.length; i++){
            if (nums[i] > max){
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