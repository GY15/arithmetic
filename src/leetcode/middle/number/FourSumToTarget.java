package leetcode.middle.number;

import java.util.*;

public class FourSumToTarget {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res =new LinkedList<>();
            for (int i = 0; i< nums.length-3;i++){
                res.addAll(threeSumToTarget(Arrays.copyOfRange(nums,i+1,nums.length),target - nums[i],nums[i]));
            }
            removeDuplicateWithOrder(res);
            return res;
        }

        public static void main(String[] args) {
            int[] i = new int[]{-1,-1,-1,-1,3,3,2};
            new FourSumToTarget().fourSum(i, 0);
        }
        public List<List<Integer>> threeSumToTarget(int[] nums, int t,int n) {

            List<List<Integer>> res =new LinkedList<>();
            for (int i = 0; i < nums.length-2;i++){
                if (i == 0 || (i != 0 && nums[i] != nums[i-1])){
                    int target = t - nums[i];
                    int start = i + 1;
                    int end = nums.length -1 ;
                    while(start<end){
                        if (nums[start]+nums[end]==target){
                            res.add(Arrays.asList(n,nums[i],nums[start],nums[end]));
                            while (start < end && nums[start] == nums[start+1]) start++;
                            while (start < end && nums[end] == nums[end-1]) end--;
                            start++; end--;
                        } else{
                            if ((nums[start] + nums[end] > target)) {
                                end--;
                            } else {
                                start++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
    }
}
