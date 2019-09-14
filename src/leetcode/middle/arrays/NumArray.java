package leetcode.middle.arrays;

class NumArray {
    public static void main(String[] args) {
        NumArray nss = new NumArray(new int[]{7,2,7,2,0});
        nss.update(4,6);
        nss.update(0,2);
        nss.update(0,9);
        nss.update(3,8);
        nss.sumRange(0,4);
    }
    int[] sums;
    int[] nums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for(int i =0; i < nums.length;i++){
            sums[i] = (i!=0?sums[i-1]:0) + nums[i];
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        int cha = val - nums[i];
        nums[i] = val;
        for(;i< sums.length;i++){
            sums[i]+=cha;
        }
    }

    public int sumRange(int i, int j) {
        return i==0?sums[j]:sums[j]-sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */