package leetcode.middle.arrays;

public class minSubArrayLen {
    //209
    public int minSubArrayLen(int s, int[] nums) {
        int begin = 0;
        int end = 0;
        s -= nums[0];
        int res = 0;
        while(end < nums.length){
            if (s <= 0){
                if(res != 0)
                    res = Math.min(res,end-begin+1);
                else
                    res = end-begin+1;
                s += nums[begin];
                begin++;
            } else {
                if (end==nums.length-1){
                    return res;
                }
                s -= nums[++end];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new minSubArrayLen().minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
