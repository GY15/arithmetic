package internship.wangyi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MaxCover {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int n = 4;
        List<Set> baseList = new ArrayList<>();
        baseList.add(new Set(0,2));
        baseList.add(new Set(1,2));
        baseList.add(new Set(0,1));
        baseList.add(new Set(1,3));
        baseList.add(new Set(0,3));
        baseList.add(new Set(2,3));
        if (baseList.size()==0){
            System.out.println(0);
        }else{
            List<Set> coverList = new ArrayList<>(baseList);
            for (int i = 0 ; i< coverList.size();i++){
                List<Set> tempList = new ArrayList<>(coverList);
                List<Integer> baseSet = coverList.get(i).sets;
                tempList.remove(i);
                for (int j = baseSet.get(baseSet.size()-1)+1; j < n;j++){
                    if (allCover(baseSet,tempList,j)) {
                        Set newSet =new Set(baseSet,j);
                        coverList.add(newSet);
                    }
                }
            }
            int maxCover = 0;
            for (int i = 0;i < coverList.size();i++){
                maxCover = Math.max(coverList.get(i).sets.size(),maxCover);
            }
            System.out.println(maxCover);
        }
    }

    private static boolean allCover(List<Integer> baseSet, List<Set> baseList, int j) {
        List<Integer> temp = new ArrayList<>(baseSet);
        for (int i = 0 ; i< baseList.size();i++){
            if (baseList.get(i).sets.get(0)==j){
                remove(temp,baseList.get(i).sets.get(1));
            }else  if (baseList.get(i).sets.get(1)==j) {
                remove(temp, baseList.get(i).sets.get(0));
            }
        }
        return temp.size()==0;
    }

    private static void remove(List<Integer> baseSet, int num) {
        for (int i = 0; i< baseSet.size();i++){
            if (num==baseSet.get(i)){
                baseSet.remove(i);
                break;
            }
        }
    }



    static class Set{
        List<Integer> sets;

        public Set(int first, int second) {
            sets = new ArrayList<>();
            sets.add(first);
            sets.add(second);
        }
        public Set(List<Integer> list,int n){
            sets = new ArrayList<>(list);
            sets.add(n);
        }
        public int inSet(Set set){
            for (int i = 0;i < set.sets.size();i++){
                if (this.sets.get(0)==set.sets.get(i)){
                    return sets.get(1);
                }
                else if (this.sets.get(1)==set.sets.get(i)){
                    return sets.get(0);
                }
            }
            return -1;
        }
    }


}
