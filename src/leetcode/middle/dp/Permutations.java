package leetcode.middle.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations {
    public static void main(String[] args) {
        new Permutations().permute(new int[]{1,1,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            numList.add(nums[i]);
        }
        addnext(new ArrayList<Integer>(),numList,res);

        return res;
    }
    private void addnext(List<Integer> list,List<Integer> nums,List<List<Integer>> res){
        if (nums.size()==0){
            res.add(list);
        }
        for (int i = 0; i < nums.size(); i++){
            if (i>0 && nums.get(i).intValue()==nums.get(i-1).intValue()){
                continue;
            }
            List<Integer> numList = new ArrayList<>(nums);
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(nums.get(i));
            numList.remove(i);
            addnext(list2,numList,res);
        }
    }
}
