package leetcode.middle.sort;

public class sortColor {
    public static void main(String[] args) {
        new sortColor().sortColors(new int[]{2,0,1});
    }
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        for(int k =0;k < nums.length&&k<=j;k++){
            switch(nums[k]){
                case 0:
                    nums[k] = 1;
                    nums[i]=0;
                    i++;
                    break;
                case 1:

                    break;
                case 2:
                    nums[k] = 1;
                    while(nums[j]==2){
                        j--;
                    }
                    if(nums[j]==0){
                        nums[i]=0;
                        i++;
                    }
                    nums[j] = 2;
                    j--;
                    break;
            }
        }

    }
}
