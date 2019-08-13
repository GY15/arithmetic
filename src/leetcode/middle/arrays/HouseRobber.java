package leetcode.middle.arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int rob1 = nums[0], notRob1 = 0, rob2 = 0,notRob2 = 0;
        for(int i = 1; i < nums.length;i++){
            if (i!=nums.length-1) {
                int curRob1 = notRob1 + nums[i];
                notRob1 = Math.max(notRob1, rob1);
                rob1 = curRob1;
            }
            int curRob2 = notRob2 + nums[i];
            notRob2 = Math.max(notRob2,rob2);
            rob2 = curRob2;
        }
        return Math.max(Math.max(rob2,notRob2),Math.max(rob1,notRob1));
    }

    public static void main(String[] args) {
        new HouseRobber().rob(new int[]{2,3,2});
    }
}
