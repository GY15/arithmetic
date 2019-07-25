package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// 获得一个数组中两个值，其相加为目标值
public class i_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(new i_TwoSum().twoSum(new int[]{2,7,11,15},9).length);
    }
}
