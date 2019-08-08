package leetcode.middle.number;

import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<nums.length;i++){
            list.add(nums[i]+"");
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.equals(o2)){
                return 1;
            }
            int num = -1;
            if (o1.length() < o2.length()){
                String o = o2;
                o2 = o1;
                o1 = o;
                num = 1;
            }
            for (int n = o1.length()-o2.length(); n > 0;n--){
                o2 += o2.charAt(0);
            }
            return num * o1.compareTo(o2);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list){
            if (stringBuilder.toString().equals("0")){
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new LargestNumber().largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247});
    }
}
