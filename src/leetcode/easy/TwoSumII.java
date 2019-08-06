package leetcode.easy;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length-1; i < j;){
            if (numbers[j] > target){
                j--;
            }
            if (target == numbers[j]+numbers[i]){
                return new int[]{i,j};
            }else if (target < numbers[j]+numbers[i]){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}
