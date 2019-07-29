package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0; i< nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                if (map.get(nums[i])==1){
                    map.put(nums[i],2);
                }else {
                    map.remove(nums[i]);
                }
            }
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        return keys[0];
    }
}
