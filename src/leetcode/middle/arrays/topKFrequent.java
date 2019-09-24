package leetcode.middle.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(k == 0|| nums.length == 0){
            return new ArrayList();
        }
        List<List<Integer>> levels = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int level = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],level);
            if(levels.size() < level){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                levels.add(list);
            } else {
                levels.get(level - 1).add(nums[i]);
            }
        }
        for(int i = levels.size()-1;i >= 0; i--){
            if(levels.get(i).size()>=k){
                return levels.get(i);
            }
        }
        return levels.get(0);
    }

    public static void main(String[] args) {
        new topKFrequent().topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
}
