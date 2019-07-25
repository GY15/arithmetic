package leetcode.middle.number;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 0;i<nums.length;i++){
            for (int j = 0;j< lists.size();j++){
                if (!lists.get(j).contains(nums[i])){
                    List<Integer> list =new ArrayList<>(lists.get(j));
                    list.add(nums[i]);
                    lists.add(list);
                }else{
                    break;
                }
            }
        }
        return lists;
    }
}