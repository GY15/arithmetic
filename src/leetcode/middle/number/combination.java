package leetcode.middle.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combination {
    /*
    * Basically, this solution follows the idea of the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).
        用笔写一下就知道了
    Here C(n,k) is divided into two situations. Situation one, number n is selected,
    so we only need to select k-1 from n-1 next. Situation two, number n is not selected,
    and the rest job is selecting k from n-1.
    *
    *
    * */
    public static void main(String[] args) {
        new combination().combine(4,2);
    }
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> lists =new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(int i =1;i<=n;i++){
            list.add(i);
        }
        add(lists,list,new ArrayList<Integer>(),k);
        return lists;
//        List<List<Integer>> result = combine(n - 1, k - 1);
//        for (List<Integer> list : result) {
//            list.add(n);
//        }
//        result.addAll(combine(n - 1, k));
//        return result;
    }

    private void add(List<List<Integer>> lists, List<Integer> list,List<Integer> list2, int k) {
        if (k == 0){
            lists.add(new ArrayList<>(list2));
        }else{
            List<Integer> list1 =new ArrayList<>(list);
            for (int i = 0; i < list.size();i++){
//                int cur = list1.remove(0);
                list2.add(list1.remove(0));
                add(lists,list1,list2,k-1);
                list2.remove(list2.size()-1);
//                list1.add
            }
        }
    }
}
