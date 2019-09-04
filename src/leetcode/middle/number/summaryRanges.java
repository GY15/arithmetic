package leetcode.middle.number;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    //228
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0){
            return list;
        }
        int last = nums[0];
        int begin = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == last + 1){
                last = nums[i];
            }else{
                if (begin==last) {
                    list.add(begin+"");
                }else {
                    list.add(begin + "->" + last);
                }
                begin = nums[i];
                last = begin;
            }
        }
        return list;
    }
}
