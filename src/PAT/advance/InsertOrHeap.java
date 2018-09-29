package PAT.advance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertOrHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] initial = new int[n];
        int[] mid = new int[n];
        for (int i = 0; i < n; i++){
            initial[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            mid[i]=scanner.nextInt();
        }

        JudgeResult insert = judgeInsert(initial,mid);
        if(insert.isInsert){
            System.out.println("Insertion Sort");
            System.out.print(insert.list.get(0));
            for (int i = 1; i < insert.list.size();i++){
                System.out.print(" "+insert.list.get(i));
            }
        }else{
            int[] res = judgeMerge(mid,2);
            System.out.println("Heap Sort");
            System.out.print(res[0]);
            for (int i = 1; i < res.length;i++){
                System.out.print(" "+res[i]);
            }
        }
    }
    private static int[] judgeMerge(int[] mid,int n){
        int max = mid[0];
        List<Integer> unsorted = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        int i = 1;
        sorted.add(max);
        for (;max > mid[i];i++){
            unsorted.add(mid[i]);
        }
        for (;i < mid.length;i++){
            sorted.add(mid[i]);
        }
        int temp = unsorted.get(unsorted.size()-1);
        unsorted.remove(unsorted.size()-1);
        unsorted.add(0,temp);
        Integer[] needSorted = unsorted.toArray(new Integer[unsorted.size()]);

        int point = 0;
        while(judgeIsValid(needSorted,point)){
            if (needSorted[point].intValue() < needSorted[point*2+1].intValue()){
                if(point*2+2<needSorted.length && needSorted[point*2+1] < needSorted[point*2+2]){
                    temp = needSorted[point];
                    needSorted[point] = needSorted[point*2+2];
                    needSorted[point*2+2] =temp;

                    point = point*2+2;
                }else {
                    temp = needSorted[point];
                    needSorted[point] = needSorted[point * 2 + 1];
                    needSorted[point * 2 + 1] = temp;

                    point = point * 2 + 1;
                }
            }else{
                temp = needSorted[point];
                needSorted[point] = needSorted[point*2+2];
                needSorted[point*2+2] =temp;

                point = point*2+2;
            }
        }
        int res[] = new int[mid.length];
        int j =0;
        for (; j < needSorted.length;j++){
            res[j] = needSorted[j];
        }
        for (int l = 0; l < sorted.size();l++){
            res[j] = sorted.get(l);
            j++;
        }
        return res;
    }

    private static boolean judgeIsValid(Integer[] needSorted,int point) {
        if(point*2+1<needSorted.length){
            if (needSorted[point].intValue() < needSorted[point*2+1].intValue()){
                return true;
            }
            if(point*2+2<needSorted.length){
                if (needSorted[point].intValue() < needSorted[point*2+2].intValue()){
                    return true;
                }
            }
        }
        return false;
    }

    static class JudgeResult {
        boolean isInsert=false;
        List<Integer> list;
    }
    private static JudgeResult judgeInsert(int[] initial, int[] mid) {
        JudgeResult insert =new JudgeResult();
        List<Integer> temp1 = new LinkedList<>();
        for (int i = 0; i < initial.length; i++){
            temp1.add(initial[i]);
        }
        for (int i = 1; i < initial.length; i++){
            for (int j = 0; j < i; j++){
                if(initial[i] < temp1.get(j)){
                    temp1.remove(i);
                    temp1.add(j,initial[i]);
                    break;
                }
            }
            if(insert.isInsert) {
                if (equals(mid, temp1)) {

                } else {
                    insert.list = temp1;
                    return insert;
                }
            }
            if(equals(mid,temp1)){
                insert.isInsert = true;
            }
        }
        return insert;
    }

    private static boolean equals(int[] mid, List<Integer> temp1) {
        for (int i = 0; i < mid.length; i++){
            if(mid[i] != temp1.get(i)){
                return false;
            }
        }
        return true;
    }
}
