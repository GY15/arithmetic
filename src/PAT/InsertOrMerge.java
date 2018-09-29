package PAT;
import java.lang.reflect.Array;
import java.util.*;

public class InsertOrMerge {
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
            insert = judgeMerge(initial,mid,2);
            System.out.println("Merge Sort");
            System.out.print(insert.list.get(0));
            for (int i = 1; i < insert.list.size();i++){
                System.out.print(" "+insert.list.get(i));
            }
        }
    }
    private static JudgeResult judgeMerge(int[] initial, int[] mid,int n){
        JudgeResult judgeResult = null;
        if(Arrays.equals(initial,mid)){
            judgeResult= new JudgeResult();
        }
        for (int i = 0; i < initial.length;i+=n){
            int start = i;
            int size = Math.min(initial.length-i,n);
            int[] temp = new int[size];
            for (int j = 0; j < size;j++){
                temp[j] = initial[start+j];
            }
            Arrays.sort(temp);
            for (int j = 0; j < size;j++){
                initial[start+j] = temp[j];
            }
        }
        if(judgeResult!=null) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < initial.length; i++) {
                list.add(initial[i]);
            }
            judgeResult.list = list;
            return judgeResult;
        }
        return judgeMerge(initial,mid,n*2);
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
