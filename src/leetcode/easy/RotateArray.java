package leetcode.easy;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(k==0 || nums.length==1 || nums.length == k){
            return;
        }
        k = k%nums.length;
        int total = nums.length;
        for (int i = 0; i < k &&total>0 ;i++){
            int last = nums[i];
            for (int j = i + k; j != i;j = (j+k)%nums.length){
                total--;
                int n = nums[j];
                nums[j] = last;
                last = n;
            }
            nums[i] = last;
            total--;
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2}, 3);
    }
}

