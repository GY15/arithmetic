package leetcode.middle.number;

import java.util.ArrayList;
import java.util.List;

public class subset2 {
    public static void main(String[] args) {
        new subset2().subsetsWithDup(new int[]{1,2,2,3});
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        int lastIndex = 0;
        int lastIndex2 = 1;
        for (int i = 0;i<nums.length;i++){
            if (i != 0){
                if (nums[i] != nums[i-1]){
                    lastIndex = 0;
                }
            }
            for (int j = lastIndex;j < lastIndex2;j++){
                List<Integer> list =new ArrayList<>(lists.get(j));
                list.add(nums[i]);
                lists.add(list);
            }
            lastIndex = lastIndex2;
            lastIndex2 = lists.size() ;
        }
        return lists;
    }
}
