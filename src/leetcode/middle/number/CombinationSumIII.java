package leetcode.middle.number;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        checkNext(lists,list,1, n,k);
        return lists;
    }
    private void checkNext(List<List<Integer>> lists, List<Integer> list, int cur, int left,int k){
        if (k == 1){
            if (left < 10 && left >= cur){
                list.add(left);
                lists.add(list);
            }
            return;
        }
        for (int i = cur; i < 10;i++){
            if (left <= i * k){
                break;
            }
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(i);
            checkNext(lists,list1,i+1,left-i,k-1);
        }
    }

    public static void main(String[] args) {
        new CombinationSumIII().combinationSum3(3,7);

    }
}
